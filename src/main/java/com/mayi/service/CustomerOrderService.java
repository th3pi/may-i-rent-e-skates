package com.mayi.service;


import com.mayi.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService {

    List<CustomerOrder> getAllCustomerOrders();

    List<CustomerOrder> getAllCustomerOrdersById(int id);

    void addCustomerOrder(CustomerOrder customerOrder);

    void updateOrderStatus(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrderById(int id);

    double getCustomerOrderGrandTotal(int cartId);

    List<CustomerOrder> getOrderStatus(String status);

//    void getOrderGrandTotal(CustomerOrder customerOrder);
}
