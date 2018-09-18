package com.mayi.dao.impl;

import com.mayi.model.OrderDetails;
import com.mayi.service.OrderDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderDetailsDaoImplTest {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Test
    public void getAllOrderDetails() {
        assertEquals(91,orderDetailsService.getAllOrderDetails().size());
    }

    @Test
    public void getOrderDetailsById() {
        assertEquals(13,orderDetailsService.getOrderDetailsById(870).getQuantity());
    }

    @Test
    public void addOrderDetails() {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setTotal(50);
        orderDetailsService.addOrderDetails(orderDetails);
        assertEquals(92,orderDetailsService.getAllOrderDetails().size());
    }

    @Test
    public void getOrderDetailsByOrderId() {
        assertEquals(13,orderDetailsService.getOrderDetailsByOrderId(869).getQuantity());
    }

    @Test
    public void getAllOrderDetailsByOrderId() {
        assertEquals(6,orderDetailsService.getAllOrderDetailsByOrderId(615).size());
    }
}