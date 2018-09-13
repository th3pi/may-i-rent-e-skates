package com.mayi.controller;

import com.mayi.model.*;
import com.mayi.service.CartService;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.CustomerService;
import com.mayi.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private CartService cartService;

    /**
     * Gets the cart associated with logged in User.
     * @param activeUser gets the logged in user's username.
     * @return return the cartId in the url.
     */

    @RequestMapping("/cart")
    public String getCart(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/"+cartId;
    }

    /**
     * Adds cart items to the cart page
     * @param cartId gets the users cart id.
     * @param model adds cart items to the view
     * @return return the cart
     */

    @RequestMapping("/cart/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model) {
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();
        boolean more = false;
        for (CartItem cartItem: cartItems) {
            if(cartItem.getQuantity() > Integer.parseInt(cartItem.getProduct().getProductRentLimit())){
                more = true;
            }
        }
        model.addAttribute("cart",cart);
        model.addAttribute("cartItems",cartItems);
        model.addAttribute("cartId", cartId);
        model.addAttribute("more",more);
        return "cart";
    }

}
