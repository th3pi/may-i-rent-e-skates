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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CartDaoImplTest {

    @Autowired
    private CartService cartService;

    @Test
    public void getCartById() {
        Cart cart = cartService.getCartById(518);
        double expectedTotal = cart.getGrandTotal();
        assertEquals(55.96,expectedTotal);
    }


    @Test
    public void updateCart() {
        Cart cart = cartService.getCartById(518);
        cart.setGrandTotal(60);
        cartService.updateCart(cart);
        double expectedTotal = cart.getGrandTotal();
        assertEquals(60,expectedTotal);
    }


}