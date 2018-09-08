package com.mayi.dao.impl;

import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import com.mayi.model.Customer;
import com.mayi.model.Product;
import com.mayi.service.CartItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartItemDaoImplTest {

    @Autowired
    private CartItemService cartItemService;

    @Test(expected = NullPointerException.class)
    @Rollback(true)
    public void addCartItem() {
        Customer customer = new Customer();
        Product product = new Product();
        product.setProductID(12);
        customer.setCustomerId(7);
        Cart cart = new Cart();
        cart.setCartId(12);
        cart.setGrandTotal(23.98);
        cart.setCustomer(customer);
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setTotalPrice(23.98);
        cartItem.setQuantity(5);
        cartItem.setCartItemId(12);
        cartItem.setProduct(product);
        cartItemService.addCartItem(cartItem);
        assertEquals(12,cartItemService.getCartItemByProductId(product.getProductID()).getCartItemId());
    }

    @Test(expected = NullPointerException.class)
    @Rollback(true)
    public void clearCart() {
        Customer customer = new Customer();
        Product product = new Product();
        product.setProductID(12);
        customer.setCustomerId(7);
        Cart cart = new Cart();
        cart.setCartId(12);
        cart.setGrandTotal(23.98);
        cart.setCustomer(customer);
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setTotalPrice(23.98);
        cartItem.setQuantity(5);
        cartItem.setCartItemId(12);
        cartItem.setProduct(product);
        List<CartItem> cartItemList = new ArrayList<CartItem>();
        cartItemList.add(cartItem);
        cart.setCartItems(cartItemList);
        cartItemService.addCartItem(cartItem);
        cartItemService.clearCart(cart);
        assertEquals(0,cart.getCartItems().size());
    }

    @Test(expected = NullPointerException.class)
    @Rollback(true)
    public void getCartItemByProductId() {
        Customer customer = new Customer();
        Product product = new Product();
        product.setProductID(12);
        customer.setCustomerId(7);
        Cart cart = new Cart();
        cart.setCartId(12);
        cart.setGrandTotal(23.98);
        cart.setCustomer(customer);
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setTotalPrice(23.98);
        cartItem.setQuantity(5);
        cartItem.setCartItemId(12);
        cartItem.setProduct(product);
        assertEquals(12,cartItemService.getCartItemByProductId(12).getCartItemId());
    }
}