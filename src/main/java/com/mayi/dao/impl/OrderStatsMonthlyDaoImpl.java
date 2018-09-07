package com.mayi.dao.impl;


import com.mayi.dao.OrderStatsMonthlyDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.model.OrderStatsYearly;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@Repository
@Transactional
public class OrderStatsMonthlyDaoImpl implements OrderStatsMonthlyDao {

    @Autowired
    private SessionFactory sessionFactory;


    public OrderStatsMonthly getOrderStatsByDate(String date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsMonthly where month = ?");
        query.setString(0,date);
        return (OrderStatsMonthly) query.list().get(query.list().size()-1);
    }

    public List<OrderStatsMonthly> getAllOrderStats() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsMonthly");
        return query.list();
    }

    public void addOrderStats(OrderStatsMonthly orderStats) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderStats);
        session.flush();
    }

    public void getTotalSales(List<CustomerOrder> orderDetails) {
        double sales = 0;
        DateFormat dateFormat = new SimpleDateFormat("MM");
        Date date = new Date();
        for(CustomerOrder order : orderDetails){
            if(!order.getOrderStatus().equals("Order Awaiting Confirmation")){
                sales += order.getOrderTotal();
            }
        }
        OrderStatsMonthly orderStatsMonthly = new OrderStatsMonthly();
        orderStatsMonthly.setMonth(dateFormat.format(date));
        orderStatsMonthly.setSales(sales);
        List<OrderStatsMonthly> orderStatsMonthlies = getAllOrderStats();
        if(sales != orderStatsMonthlies.get(orderStatsMonthlies.size()-1).getSales()){
            addOrderStats(orderStatsMonthly);
        }
    }
}
