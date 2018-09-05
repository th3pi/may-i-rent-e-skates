package com.mayi.service;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsDaily;
import com.mayi.model.OrderStatsMonthly;

import java.util.List;

public interface OrderStatsDailyService {
    OrderStatsDaily getOrderStatsByDate(String date);

    List<OrderStatsDaily> getAllOrderStats();
    void addOrderStats(OrderStatsDaily orderStats);

    void getTotalSales(List<CustomerOrder> orderDetails);
}
