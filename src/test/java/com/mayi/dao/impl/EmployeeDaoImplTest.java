package com.mayi.dao.impl;

import com.mayi.model.Customer;
import com.mayi.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeDaoImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void addEmployee() {
        Customer customer = new Customer();
        customer.setCustomerName("Tanjim");
        customer.setCustomerEmail("E@gmail.com");
        customer.setPassword("1234567");
        customerService.addCustomer(customer);
        Customer newCustomer = customerService.getCustomerByUsername(customer.getUsername());
        assertEquals(newCustomer.getUsername(),customer.getUsername());
    }
}