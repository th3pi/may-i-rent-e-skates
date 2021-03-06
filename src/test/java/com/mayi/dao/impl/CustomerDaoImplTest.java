package com.mayi.dao.impl;

import com.mayi.model.Customer;
import com.mayi.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDaoImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setCustomerName("Tanjim");
        customer.setCustomerEmail("T@gmail.com");
        customer.setPassword("1234567");
        customerService.addCustomer(customer);
        Customer newCustomer = customerService.getCustomerByUsername(customer.getUsername());
        assertEquals(newCustomer.getUsername(),customer.getUsername());
    }

    @Test
    public void getCustomerById() {
        Customer customer = customerService.getCustomerById(757);
        assertEquals("t@g",customer.getUsername());
    }

    @Test
    public void getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        assertEquals(22,customerList.size());
    }

    @Test
    public void getCustomerByUsername() {
        Customer customer = customerService.getCustomerByUsername("t@g");
        assertEquals(757,customer.getCustomerId());
    }
}