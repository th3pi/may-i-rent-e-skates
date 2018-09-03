package com.mayi.service;


import com.mayi.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrder> getAllCustomerOrders();

    void addCustomerOrder(CustomerOrder customerOrder);

    void updateOrderStatus(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrderById(int id);

    double getCustomerOrderGrandTotal(int cartId);

//    void getOrderGrandTotal(CustomerOrder customerOrder);
}
