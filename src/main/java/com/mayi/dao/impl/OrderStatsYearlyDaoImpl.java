package com.mayi.dao.impl;


import com.mayi.dao.OrderStatsYearlyDao;
import com.mayi.model.CustomerOrder;
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

@Repository
@Transactional
public class OrderStatsYearlyDaoImpl implements OrderStatsYearlyDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<OrderStatsYearly> getAllOrderStats() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly");
        return query.list();
    }

    public OrderStatsYearly getOrderStatsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly where orderStatsId = ?");
        query.setInteger(0,id);
        return (OrderStatsYearly) query.uniqueResult();
    }

    public OrderStatsYearly getOrderStatsByProductId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly where productId = ?");
        query.setInteger(0,id);
        return (OrderStatsYearly) query.uniqueResult();
    }

    public OrderStatsYearly getOrderStatsByDate(String date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly where year = ?");
        query.setString(0,date);
        List<OrderStatsYearly> orderStatsYearlies = query.list();
        return orderStatsYearlies.get(orderStatsYearlies.size()-1);
    }

    public void addOrderStats(OrderStatsYearly orderStats) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderStats);
        session.flush();
    }

    public void getTotalSalesYTD(List<CustomerOrder> orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        double sales = 0;
        DateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date = new Date();
        for(CustomerOrder orderDetails1 : orderDetails){
            String currentYear = Integer.toString(orderDetails1.getOrderDate().charAt(6)) +
                    Integer.toString(orderDetails1.getOrderDate().charAt(7)) +
                    Integer.toString(orderDetails1.getOrderDate().charAt(8)) +
                    Integer.toString(orderDetails1.getOrderDate().charAt(9));
            if(!orderDetails1.getOrderStatus().equals("Order Awaiting Confirmation") && currentYear.equals(dateFormat.format(date))) {
                sales += orderDetails1.getOrderTotal();
            }
        }
        OrderStatsYearly orderStats = new OrderStatsYearly();
        orderStats.setYear(dateFormat.format(date));
        orderStats.setSales(sales);
        Query query = session.createQuery("from OrderStatsYearly");
        List<OrderStatsYearly> previousStats = query.list();
        if(previousStats.size() > 0) {
            if (sales != previousStats.get(previousStats.size() - 1).getSales()) {
                addOrderStats(orderStats);
            }
        }
    }

    public void deleteOrderStats(OrderStatsYearly orderStats) {

    }
}
