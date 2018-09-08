package com.mayi.dao;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsDaily;

import java.util.List;

public interface OrderStatsDailyDao {
    OrderStatsDaily getOrderStatsByDate(String date);

    List<OrderStatsDaily> getAllOrderStats();
    void addOrderStats(OrderStatsDaily orderStats);
    List<OrderStatsDaily> getFirstDayOfEachMonth(String[] dates);

    void getTotalSales(List<CustomerOrder> orderDetails);
}
