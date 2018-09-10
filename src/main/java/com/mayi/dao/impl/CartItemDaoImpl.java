package com.mayi.dao.impl;

import com.mayi.dao.CartItemDao;
import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Adds a product to the cart as a cart item, saves to database
     * @param cartItem cart item / product passed from controller
     */
    public void addCartItem(CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    /**
     * Removes a product from the cart and saves to database
     * @param cartItem cart item / product passed from controller
     */

    public void removeCartItem (CartItem cartItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        session.flush();
    }

    /**
     * Clears the entire cart
     * @param cart passed from controller
     */

    public void clearCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    /**
     * Just to query a certain product from the cart, gets cart item from a cart based on product id
     * @param productId passed from controller
     * @return the queried product
     */

    public CartItem getCartItemByProductId (int productId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where productId = ?");
        query.setInteger(0, productId);
        session.flush();

        return (CartItem) query.uniqueResult();
    }
}
