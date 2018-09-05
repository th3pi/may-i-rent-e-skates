package com.mayi.service;

import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.model.OrderStatsYearly;

import java.util.List;

public interface OrderStatsYearlyService {

    List<OrderStatsYearly> getAllOrderStats();

    OrderStatsYearly getOrderStatsById(int id);

    OrderStatsYearly getOrderStatsByProductId(int id);

    OrderStatsYearly getOrderStatsByDate(String date);

    void addOrderStats(OrderStatsYearly orderStats);

    void getTotalSalesYTD(List<CustomerOrder> orderDetails);

    void deleteOrderStats(OrderStatsYearly orderStats);
}
