package com.mayi.dao.impl;

import com.mayi.dao.CartDao;
import com.mayi.model.Cart;
import com.mayi.service.CustomerOrderService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CustomerOrderService customerOrderService;

    /**
     * Gets cart by id
     * @param cartId contextual cart id
     * @return returns cart associated with cart id
     */

    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();

        return (Cart) session.get(Cart.class,cartId);
    }

    /**
     * Updates cart items and cart total
     * @param cart passed from controller or validate method
     */

    public void updateCart(Cart cart) {
        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    /**
     * Validates the cart's existence.
     * @param cartId passed from controller
     * @return returns the validated cart
     * @throws IOException incase the cart is invalid
     */

    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if(cart == null || cart.getCartItems().size() == 0){
            throw new IOException(cartId + "");
        }

        updateCart(cart);
        return cart;
    }
}