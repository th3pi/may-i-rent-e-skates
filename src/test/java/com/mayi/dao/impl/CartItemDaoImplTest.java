package com.mayi.dao.impl;

import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import com.mayi.model.Customer;
import com.mayi.model.Product;
import com.mayi.service.CartItemService;
import com.mayi.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CartItemDaoImplTest {

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private CartService cartService;

    @Test
    public void addCartItem() {
        CartItem cartItem = cartItemService.getCartItemByProductId(12);
        Cart cart = cartService.getCartById(518);
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        double expectedTotal = cart.getGrandTotal();
        assertEquals(65.95,expectedTotal);
    }

    @Test
    public void removeCartItem() {
        CartItem cartItem = cartItemService.getCartItemByProductId(12);
        Cart cart = cartService.getCartById(518);
        cartItem.setCart(cart);
        cartItemService.removeCartItem(cartItem);
        double expectedTotal = cart.getGrandTotal();
        assertEquals(55.96,expectedTotal);
    }

    @Test
    public void clearCart() {
        Cart cart = cartService.getCartById(518);
        cartItemService.clearCart(cart);
        assertEquals(0,cart.getGrandTotal());
    }

    @Test
    public void getCartItemByProductId() {
        Cart cart = cartService.getCartById(518);
        CartItem cartItem = cartItemService.getCartItemByProductId(12);
        cartItem.setCart(cart);
        assertEquals("Boosted",cartItem.getProduct().getProductManufacturer());
    }
}