package com.mayi.service;

import com.mayi.model.Cart;
import com.mayi.model.Customer;

public interface CartService {

    Cart getCartById(int cartId);

    void updateCart(Cart cart);
}
