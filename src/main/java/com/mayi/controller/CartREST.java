package com.mayi.controller;


import com.mayi.model.*;
import com.mayi.service.CartItemService;
import com.mayi.service.CartService;
import com.mayi.service.CustomerService;
import com.mayi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/rest/cart")
public class CartREST {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    /**
     * This is REST cart service controller
     */

    /**
     * Gets cart by Id
     * @param cartId gets contextual cart id.
     * @return the cart
     */
    @RequestMapping("/{cartId}")
    public @ResponseBody
    Cart getCartById (@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    /**
     * Adds a product to cart.
     * @param productId the product to be added to cart
     * @param activeUser the user logged in.
     */

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem (@PathVariable(value ="productId") int productId, @AuthenticationPrincipal User activeUser) {

        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        Cart cart = customer.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();


        //If the item being added to cart has already been added previously - quantity gets updated
        for (int i=0; i<cartItems.size(); i++) {
            if(product.getProductID()==cartItems.get(i).getProduct().getProductID()){
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity()+1);
                cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
                cartItemService.addCartItem(cartItem);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(product.getProductPrice()*cartItem.getQuantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
    }

    /**
     * Removes product form the cart.
     * @param productId the product to be removed
     */

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem (@PathVariable(value = "productId") int productId) {
        CartItem cartItem = cartItemService.getCartItemByProductId(productId);
        cartItemService.removeCartItem(cartItem);

    }

    /**
     * Clears the cart. Gets rid of all items.
     * @param cartId the cart to be cleared
     */

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void clearCart(@PathVariable(value = "cartId") int cartId) {
        Cart cart = cartService.getCartById(cartId);
        cartItemService.clearCart(cart);
    }

    /**
     * Handles clientside errors
     * @param e exceptions
     */

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload.")
    public void handleClientErrors (Exception e) {}

    /**
     * Handles serverside errors
     * @param e exceptions
     */

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal Server Error.")
    public void handleServerErrors (Exception e) {}
}
