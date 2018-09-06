package com.mayi.controller;

import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import com.mayi.model.Customer;
import com.mayi.service.CartService;
import com.mayi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(assignableTypes = ProductController.class)
public class CartGlobalController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartService cartService;

    @ModelAttribute("cartItems")
    public List<CartItem> getCartSize(@AuthenticationPrincipal User user){
        Customer customer = customerService.getCustomerByUsername(user.getUsername());
        Cart cart = cartService.getCartById(customer.getCart().getCartId());
        return cart.getCartItems();
    }
}
