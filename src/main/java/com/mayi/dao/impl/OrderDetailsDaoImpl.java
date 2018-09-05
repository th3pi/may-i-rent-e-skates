package com.mayi.dao.impl;


import com.mayi.dao.OrderDetailsDao;
import com.mayi.model.*;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.OrderStatsYearlyService;
import com.mayi.service.ProductService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private OrderStatsYearlyService orderStatsYearlyService;

    public List<OrderDetails> getAllOrderDetails() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails");
        return query.list();
    }

    public OrderDetails getOrderDetailsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails where orderdetailsId = ?");
        query.setInteger(0,id);
        return (OrderDetails) query.uniqueResult();
    }

    public void addOrderDetails(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderDetails);
        session.flush();
    }

    public void insertNewProduct(int orderId) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(orderId);
        List<CartItem> cartItems = customerOrder.getCart().getCartItems();
        int quantity = 1;
        for(CartItem cartItem : cartItems){
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProduct(cartItem.getProduct());
            orderDetails.setQuantity(cartItem.getQuantity());
            orderDetails.setTotal(customerOrderService.getCustomerOrderGrandTotal(customerOrder.getCart().getCartId()));
            orderDetails.setCustomerOrder(customerOrder);
            addOrderDetails(orderDetails);
        }
    }

    public OrderDetails getOrderDetailsByOrderId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails where customerorderid = ?");
        query.setInteger(0,id);
        return (OrderDetails) query.list().get(0);
    }

    public List<OrderDetails> getAllOrderDetailsByOrderId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails where customerorderid = ?");
        query.setInteger(0,id);
        List<OrderDetails> orderDetailsList = query.list();
        session.flush();
        return orderDetailsList;
    }

//    public double getTotalMonthly(List<OrderDetails> orderDetails, int month) {
//        Session session = sessionFactory.getCurrentSession();
//        double sales = 0;
//        for(OrderDetails orderDetails1 : orderDetails){
//            switch (month){
//                case 1:
//                    Query query = session.createQuery("from CustomerOrder where orderDate between '01/01/2018' and '01/31/2018'");
//                    List<CustomerOrder> customerOrders = query.list();
//
//            }
//        }
//        OrderStats orderStats = new OrderStats();
//        orderStats.setSalesYTD(sales);
//        orderStatsYearlyService.addOrderStats(orderStats);
//        return sales;
//    }

    public void removeOrderDetails(OrderDetails orderDetails) {

    }
}
