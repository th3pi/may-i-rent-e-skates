package com.mayi.dao;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.model.OrderStatsYearly;

import java.util.List;

public interface OrderStatsMonthlyDao {

    OrderStatsMonthly getOrderStatsByDate(String date);

    List<OrderStatsMonthly> getAllOrderStats();
    void addOrderStats(OrderStatsMonthly orderStats);

    void getTotalSales(List<CustomerOrder> orderDetails);
}
