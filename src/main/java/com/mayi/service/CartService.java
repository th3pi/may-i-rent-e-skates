package com.mayi.service;

import com.mayi.model.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}
