package com.mayi.dao.impl;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsDaily;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.OrderStatsDailyService;
import com.mayi.service.OrderStatsMonthlyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderStatsMonthlyDaoImplTest {

    @Autowired
    private OrderStatsMonthlyService orderStatsMonthlyService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Test
    public void getOrderStatsByDate() {
        assertEquals(245,orderStatsMonthlyService.getOrderStatsByDate("09").getOrderStatsId());
    }

    @Test
    public void getAllOrderStats() {
        assertEquals(25,orderStatsMonthlyService.getAllOrderStats().size());
    }

    @Test
    public void addOrderStats() {
        OrderStatsMonthly orderStatsMonthly = new OrderStatsMonthly();
        orderStatsMonthlyService.addOrderStats(orderStatsMonthly);
        String inputTodayDate = "09";
        assertEquals(inputTodayDate,orderStatsMonthly.getMonth());
    }

    @Test
    public void getTotalSales() {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        orderStatsMonthlyService.getTotalSales(customerOrders);
        assertEquals(3024.31,orderStatsMonthlyService.getOrderStatsByDate("09").getSales());
    }
}