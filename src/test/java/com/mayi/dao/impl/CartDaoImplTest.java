package com.mayi.dao.impl;

import com.mayi.dao.CartDao;
import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import com.mayi.model.Customer;
import com.mayi.service.CartService;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CartDaoImplTest {

    @Autowired
    private CartService cartService;

    @Autowired
    private SessionFactory sessionFactory;

    @Test(expected=NullPointerException.class)
    public void getCartById() {
        Customer customer = new Customer();
        customer.setCustomerId(7);
        Cart cart = new Cart();
        cart.setCartId(12);
        cart.setGrandTotal(23.98);
        cart.setCustomer(customer);
        Assert.assertEquals(cart,cartService.getCartById(12));
    }


    @Test(expected=NullPointerException.class)
    public void updateCart() {
        Customer customer = new Customer();
        customer.setCustomerId(7);
        Cart cart = new Cart();
        cart.setCartId(12);
        cart.setGrandTotal(24);
        cart.setCustomer(customer);
        cartService.updateCart(cart);
        assertEquals(24,cart.getGrandTotal());
    }
}