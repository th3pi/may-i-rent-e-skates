package com.mayi.dao.impl;

import com.mayi.dao.CustomerDao;
import com.mayi.model.*;
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

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addCustomer(Customer customer){
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        customer.setJoinDate(dateFormat.format(date));
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUser = new Users();
        newUser.setUsername(customer.getUsername());
        newUser.setPassword(customer.getPassword());
        newUser.setEnabled(1);
        newUser.setCustomerId(customer.getCustomerId());


        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getUsername());
        newAuthorities.setAuthority("ROLE_USER");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    public void editCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());
        session.flush();
    }

    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomer(customer);
        Cart cart = new Cart();
        cart.setCustomer(customer);
        session.delete(cart);
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCustomer(customer);
        session.delete(billingAddress);
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCustomer(customer);
        session.delete(shippingAddress);
        Users users = new Users();
        users.setCustomerId(customer.getCustomerId());
        session.delete(users);
        Authorities authorities = new Authorities();
        authorities.setUsername(customer.getUsername());
        session.delete(authorities);
        session.delete(customer);
        session.flush();
    }

    public Customer getCustomerById (int customerId) {
        Session session = sessionFactory.getCurrentSession();
        return (Customer) session.get(Customer.class, customerId);
    }

    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        return customerList;
    }

    public Customer getCustomerByUsername (String username) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where username = ?");
        query.setString(0, username);
        session.flush();
        return (Customer) query.uniqueResult();
    }
}
