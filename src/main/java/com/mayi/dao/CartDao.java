package com.mayi.dao;

import com.mayi.model.Cart;

public interface CartDao {
    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}
