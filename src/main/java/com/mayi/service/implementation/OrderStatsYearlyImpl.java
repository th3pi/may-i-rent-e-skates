package com.mayi.service.implementation;

import com.mayi.dao.OrderStatsYearlyDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.model.OrderStatsYearly;
import com.mayi.service.OrderStatsYearlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatsYearlyImpl implements OrderStatsYearlyService {

    @Autowired
    private OrderStatsYearlyDao orderStatsYearlyDao;

    public List<OrderStatsYearly> getAllOrderStats() {
        return orderStatsYearlyDao.getAllOrderStats();
    }

    public OrderStatsYearly getOrderStatsById(int id) {
        return orderStatsYearlyDao.getOrderStatsById(id);
    }

    public OrderStatsYearly getOrderStatsByProductId(int id) {
        return orderStatsYearlyDao.getOrderStatsByProductId(id);
    }

    public OrderStatsYearly getOrderStatsByDate(String date) {
        return orderStatsYearlyDao.getOrderStatsByDate(date);
    }

    public void addOrderStats(OrderStatsYearly OrderStatsYearly) {
        orderStatsYearlyDao.addOrderStats(OrderStatsYearly);
    }

    public void deleteOrderStats(OrderStatsYearly OrderStatsYearly) {
        orderStatsYearlyDao.deleteOrderStats(OrderStatsYearly);
    }

    public void getTotalSalesYTD(List<CustomerOrder> orderDetails) {
        orderStatsYearlyDao.getTotalSalesYTD(orderDetails);
    }
}
