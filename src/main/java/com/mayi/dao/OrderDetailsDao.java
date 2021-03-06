package com.mayi.dao;

import com.mayi.model.OrderDetails;

import java.util.List;

public interface OrderDetailsDao {

    List<OrderDetails> getAllOrderDetails();

    OrderDetails getOrderDetailsById(int id);

    void insertNewProduct(int orderId);

    void addOrderDetails(OrderDetails orderDetails);

    void removeOrderDetails(OrderDetails orderDetails);

    OrderDetails getOrderDetailsByOrderId(int id);


    List<OrderDetails> getAllOrderDetailsByOrderId(int id);

}
