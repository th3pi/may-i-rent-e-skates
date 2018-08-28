package com.mayi.dao;

import com.mayi.model.Cart;
import com.mayi.model.CartItem;

public interface CartItemDao {
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void clearCart(Cart cart);

    CartItem getCartItemByProductId(int productId);

}
