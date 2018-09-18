package com.mayi.dao.impl;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsYearly;
import com.mayi.model.OrderStatsYearly;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.OrderStatsMonthlyService;
import com.mayi.service.OrderStatsYearlyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderStatsYearlyDaoImplTest {

    @Autowired
    private OrderStatsYearlyService orderStatsYearlyService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Test
    public void getAllOrderStats() {
        assertEquals(244,orderStatsYearlyService.getOrderStatsByDate("2018").getOrderStatsId());
    }

    @Test
    public void getOrderStatsByDate() {
        assertEquals(26,orderStatsYearlyService.getAllOrderStats().size());
    }

    @Test
    public void addOrderStats() {
        OrderStatsYearly orderStatsYearly = new OrderStatsYearly();
        orderStatsYearlyService.addOrderStats(orderStatsYearly);
        String inputTodayDate = "2018";
        assertEquals(inputTodayDate,orderStatsYearly.getYear());
    }

    @Test
    public void getTotalSalesYTD() {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        orderStatsYearlyService.getTotalSalesYTD(customerOrders);
        assertEquals(3024.31,orderStatsYearlyService.getOrderStatsByDate("2018").getSales());
    }
}