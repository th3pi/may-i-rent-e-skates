package com.mayi.service.implementation;

import com.mayi.dao.CartDao;
import com.mayi.model.Cart;
import com.mayi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
}
