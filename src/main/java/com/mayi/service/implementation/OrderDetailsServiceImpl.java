package com.mayi.service.implementation;

import com.mayi.dao.OrderDetailsDao;
import com.mayi.model.OrderDetails;
import com.mayi.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    public List<OrderDetails> getAllOrderDetails() {
        return orderDetailsDao.getAllOrderDetails();
    }

    public OrderDetails getOrderDetailsById(int id) {
        return orderDetailsDao.getOrderDetailsById(id);
    }

    public void addOrderDetails(OrderDetails orderDetails) {
        orderDetailsDao.addOrderDetails(orderDetails);
    }

    public void removeOrderDetails(OrderDetails orderDetails) {
        orderDetailsDao.removeOrderDetails(orderDetails);
    }

    public void insertNewProduct(int orderId) {
        orderDetailsDao.insertNewProduct(orderId);
    }

    public OrderDetails getOrderDetailsByOrderId(int id) {
        return orderDetailsDao.getOrderDetailsByOrderId(id);
    }

    public List<OrderDetails> getAllOrderDetailsByOrderId(int id) {
        return orderDetailsDao.getAllOrderDetailsByOrderId(id);
    }
}
