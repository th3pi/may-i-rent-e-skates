package com.mayi.dao.impl;

import com.mayi.dao.CustomerOrderDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.model.Product;
import com.mayi.service.CartService;
import com.mayi.service.OrderDetailsService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Adds customer order to the database. Sets a date when the order was created
     * @param customerOrder passed from controller
     */

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        customerOrder.setOrderDate(dateFormat.format(date));
        customerOrder.setOrderStatus("Order Awaiting Confirmation");
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    /**
     * Gets all customer orders by customer id
     * @param id customer id passed from controller
     * @return all the customer order associated with the customer
     */

    public List<CustomerOrder> getAllCustomerOrdersById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where customerId = ? order by customerOrderId desc");
        query.setInteger(0,id);
        List<CustomerOrder> customerOrders = query.list();
        return customerOrders;
    }

    /**
     * Updates order status
     * @param customerOrder passed from controller
     */

    public void updateOrderStatus(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    /**
     * Gets all customer orders in the database
     * @return all the customer orders
     */

    public List<CustomerOrder> getAllCustomerOrders(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder order by orderDate desc");
        List<CustomerOrder> customerOrders = query.list();
        return customerOrders;
    }

    /**
     * Gets a order based on order id
     * @param id is the order id, passed from controller
     * @return the order queried
     */

    public CustomerOrder getCustomerOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where customerOrderId = ?");
        query.setInteger(0,id);
        return (CustomerOrder) query.uniqueResult();
    }

    /**
     * Gets the order status
     * @param status is the specific status passed from controller
     * @return list of orders with the specific order status
     */

    public List<CustomerOrder> getOrderStatus(String status){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where orderStatus = ?");
        query.setString(0,status);
        return query.list();
    }

}
