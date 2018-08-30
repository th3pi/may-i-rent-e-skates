package com.mayi.dao;

import com.mayi.model.Cart;

import java.io.IOException;

public interface CartDao {
    Cart getCartById(int cartId);

    void updateCart(Cart cart);

    Cart validate(int cartId) throws IOException;
}
