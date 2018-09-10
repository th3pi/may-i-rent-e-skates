package com.mayi.dao.impl;

import com.mayi.dao.CustomerDao;
import com.mayi.dao.EmployeeDao;
import com.mayi.model.Authorities;
import com.mayi.model.Cart;
import com.mayi.model.Customer;
import com.mayi.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Adds an employee to database. With authority assigned as ROLE_ADMIN.
     * @param customer passed from controller
     */

    public void addEmployee(Customer customer) {
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
        newAuthorities.setAuthority("ROLE_ADMIN");
        session.saveOrUpdate(newUser);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);
        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();
    }

    /**
     * Empty method. Unnecessary at the moment as editCustomer does the job.
     * @param customer passed from controller
     */

    public void editEmployee(Customer customer) {

    }
}
