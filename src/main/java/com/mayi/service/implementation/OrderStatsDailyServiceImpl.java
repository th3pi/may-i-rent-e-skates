package com.mayi.service.implementation;

import com.mayi.dao.OrderStatsDailyDao;
import com.mayi.dao.OrderStatsMonthlyDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsDaily;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.service.OrderStatsDailyService;
import com.mayi.service.OrderStatsMonthlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatsDailyServiceImpl implements OrderStatsDailyService {

    @Autowired
    private OrderStatsDailyDao orderStatsDailyDao;

    public OrderStatsDaily getOrderStatsByDate(String date) {
        return orderStatsDailyDao.getOrderStatsByDate(date);
    }

    public List<OrderStatsDaily> getAllOrderStats() {
        return orderStatsDailyDao.getAllOrderStats();
    }

    public void addOrderStats(OrderStatsDaily orderStats) {
        orderStatsDailyDao.addOrderStats(orderStats);
    }

    public void getTotalSales(List<CustomerOrder> orderDetails) {
        orderStatsDailyDao.getTotalSales(orderDetails);
    }
}
