package com.mayi.service.implementation;

import com.mayi.dao.OrderStatsMonthlyDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.model.OrderStatsYearly;
import com.mayi.service.OrderStatsMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatsMonthlyServiceImpl implements OrderStatsMonthlyService {

    @Autowired
    private OrderStatsMonthlyDao orderStatsMonthlyDao;

    public OrderStatsMonthly getOrderStatsByDate(String date) {
        return orderStatsMonthlyDao.getOrderStatsByDate(date);
    }

    public List<OrderStatsMonthly> getAllOrderStats() {
        return orderStatsMonthlyDao.getAllOrderStats();
    }

    public void addOrderStats(OrderStatsMonthly orderStats) {
        orderStatsMonthlyDao.addOrderStats(orderStats);
    }

    public void getTotalSales(List<CustomerOrder> orderDetails) {
        orderStatsMonthlyDao.getTotalSales(orderDetails);
    }
}
