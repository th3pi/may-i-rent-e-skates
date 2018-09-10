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
    private CustomerOrderService customerOrderService;


    /**
     * Gets all order details
     * @return returns all the order details
     */

    public List<OrderDetails> getAllOrderDetails() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails");
        return query.list();
    }

    /**
     * Gets order details by order details id
     * @param id passed from controller
     * @return the queried order details
     */

    public OrderDetails getOrderDetailsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails where orderdetailsId = ?");
        query.setInteger(0,id);
        return (OrderDetails) query.uniqueResult();
    }

    /**
     * Adds order details to the database
     * @param orderDetails passed from controller - the order details to be added
     */

    public void addOrderDetails(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        orderDetails.getCustomerOrder().setOrderTotal(orderDetails.getTotal());
        session.saveOrUpdate(orderDetails.getCustomerOrder());
        session.saveOrUpdate(orderDetails);
        session.flush();
    }

    /**
     * Insert a new product to the same order id.
     * @param orderId order id passed from controller
     */

    public void insertNewProduct(int orderId) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(orderId);
        List<CartItem> cartItems = customerOrder.getCart().getCartItems();
        int quantity = 1;
        for(CartItem cartItem : cartItems){
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProduct(cartItem.getProduct());
            orderDetails.setQuantity(cartItem.getQuantity());
            orderDetails.setLockedPrice(cartItem.getProduct().getProductPrice());
            orderDetails.setTotal(customerOrderService.getCustomerOrderGrandTotal(customerOrder.getCart().getCartId()));
            orderDetails.setCustomerOrder(customerOrder);
            addOrderDetails(orderDetails);
        }
    }

    /**
     * Gets order details based on order id
     * @param id the order id passed from controller
     * @return list of order details with the order id
     */

    public OrderDetails getOrderDetailsByOrderId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails where customerorderid = ?");
        query.setInteger(0,id);
        return (OrderDetails) query.list().get(0);
    }

    /**
     * I dont know why I created this method. Its the same one as above.
     * @param id the order id passed from controller
     * @return order details list based on the order id
     */

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


    /**
     * Not used at the moment
     * @param orderDetails passed from controller
     */
    public void removeOrderDetails(OrderDetails orderDetails) {

    }
}
