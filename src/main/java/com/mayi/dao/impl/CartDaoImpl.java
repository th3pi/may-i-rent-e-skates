package com.mayi.dao.impl;

import com.mayi.dao.CartDao;
import com.mayi.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CartDaoImpl implements CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Cart getCartById(int cartId) {
        Session session = sessionFactory.getCurrentSession();

        return (Cart) session.get(Cart.class,cartId);
    }

    public void updateCart(Cart cart) {
        int cartId = cart.getCartId();
    }
}