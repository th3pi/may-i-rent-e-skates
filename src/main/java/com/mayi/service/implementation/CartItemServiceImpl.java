package com.mayi.service.implementation;

import com.mayi.dao.CartItemDao;
import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import com.mayi.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void clearCart(Cart cart) {
        cartItemDao.clearCart(cart);
    }

    public CartItem getCartItemByProductId(int productId) {

        return cartItemDao.getCartItemByProductId(productId);
    }
}
