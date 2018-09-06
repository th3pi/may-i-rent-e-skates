package com.mayi.dao;

import com.mayi.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderDao {

    void addCustomerOrder(CustomerOrder customerOrder);

    void updateOrderStatus(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrderById(int id);

    List<CustomerOrder> getAllCustomerOrders();

    List<CustomerOrder> getAllCustomerOrdersById(int id);

    List<CustomerOrder> getOrderStatus(String status);

//    void getOrderGrandTotal(CustomerOrder customerOrder);

}
