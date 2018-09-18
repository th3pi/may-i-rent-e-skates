package com.mayi.dao.impl;

import com.mayi.model.Customer;
import com.mayi.model.CustomerOrder;
import com.mayi.service.CustomerOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerOrderDaoImplTest {


    @Autowired
    private CustomerOrderService customerOrderService;

    @Test
    public void addCustomerOrder() {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerOrderId(2);
        customerOrderService.addCustomerOrder(customerOrder);
        assertEquals(customerOrder,customerOrderService.getCustomerOrderById(2));
    }

    @Test
    public void getAllCustomerOrdersById() {
        Customer customer = new Customer();
        customer.setCustomerId(7);
        int expectedSize = 12;
        assertEquals(expectedSize,customerOrderService.getAllCustomerOrdersById(7).size());
    }

    @Test
    public void updateOrderStatus() {
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerOrderId(891);
        customerOrder.setOrderStatus("TEST");
        customerOrderService.updateOrderStatus(customerOrder);
        assertEquals("TEST",customerOrder.getOrderStatus());
    }

    @Test
    public void getAllCustomerOrders() {
        assertEquals(61,customerOrderService.getAllCustomerOrders().size());
    }

    @Test
    public void getCustomerOrderById() {
        assertEquals("TEST",customerOrderService.getCustomerOrderById(891).getOrderStatus());
    }
}