package com.mayi.dao.impl;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.model.OrderStatsDaily;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.OrderDetailsService;
import com.mayi.service.OrderStatsDailyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderStatsDailyDaoImplTest {

    @Autowired
    private OrderStatsDailyService orderStatsDailyService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Test
    public void getOrderStatsByDate() {
        assertEquals(750,orderStatsDailyService.getOrderStatsByDate("09/08/2018").getOrderStatsMonthlyId());
    }

    @Test
    public void getAllOrderStats() {
        assertEquals(30,orderStatsDailyService.getAllOrderStats().size());
    }

    @Test
    public void addOrderStats() {
        OrderStatsDaily orderStatsDaily = new OrderStatsDaily();
        orderStatsDailyService.addOrderStats(orderStatsDaily);
        String inputTodayDate = "09/18/2018";
        assertEquals(inputTodayDate,orderStatsDaily.getToday());
    }

    @Test
    public void getTotalSales() {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        orderStatsDailyService.getTotalSales(customerOrders);
        assertEquals(0,orderStatsDailyService.getOrderStatsByDate("09/18/2018").getSales());
    }
}