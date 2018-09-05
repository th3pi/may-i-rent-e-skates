package com.mayi.service;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.model.OrderStatsYearly;

import java.util.List;

public interface OrderStatsMonthlyService {
    OrderStatsMonthly getOrderStatsByDate(String date);

    List<OrderStatsMonthly> getAllOrderStats();
    void addOrderStats(OrderStatsMonthly orderStats);

    void getTotalSales(List<CustomerOrder> orderDetails);
}
