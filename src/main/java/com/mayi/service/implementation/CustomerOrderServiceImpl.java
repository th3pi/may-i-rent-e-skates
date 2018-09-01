package com.mayi.service.implementation;

import com.mayi.dao.CustomerOrderDao;
import com.mayi.model.Cart;
import com.mayi.model.CartItem;
import com.mayi.model.CustomerOrder;
import com.mayi.service.CartService;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }

    public List<CustomerOrder> getAllCustomerOrders(){
        return customerOrderDao.getAllCustomerOrders();
    }

    public CustomerOrder getCustomerOrderById(int id) {
        return customerOrderDao.getCustomerOrderById(id);
    }
}
