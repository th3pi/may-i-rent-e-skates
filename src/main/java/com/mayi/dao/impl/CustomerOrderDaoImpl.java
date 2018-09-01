package com.mayi.dao.impl;

import com.mayi.dao.CustomerOrderDao;
import com.mayi.model.CustomerOrder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        customerOrder.setOrderDate(dateFormat.format(date));
        customerOrder.setOrderStatus("Order Awaiting Confirmation");
        session.saveOrUpdate(customerOrder);
        session.flush();
    }

    public List<CustomerOrder> getAllCustomerOrders(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder");
        List<CustomerOrder> customerOrders = query.list();
        return customerOrders;
    }

    public CustomerOrder getCustomerOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CustomerOrder where customerOrderId = ?");
        query.setInteger(0,id);
        return (CustomerOrder) query.uniqueResult();
    }
}
