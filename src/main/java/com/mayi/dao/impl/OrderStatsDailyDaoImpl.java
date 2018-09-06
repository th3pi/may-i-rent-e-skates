package com.mayi.dao.impl;


import com.mayi.dao.OrderStatsDailyDao;
import com.mayi.dao.OrderStatsMonthlyDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderStatsDaily;
import com.mayi.model.OrderStatsMonthly;
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
public class OrderStatsDailyDaoImpl implements OrderStatsDailyDao {

    @Autowired
    private SessionFactory sessionFactory;


    public OrderStatsDaily getOrderStatsByDate(String date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsDaily where today = ?");
        query.setString(0,date);
        return (OrderStatsDaily) query.list().get(query.list().size()-1);
    }

    public List<OrderStatsDaily> getAllOrderStats() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsDaily");
        return query.list();
    }

    public void addOrderStats(OrderStatsDaily orderStats) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderStats);
        session.flush();
    }

    public void getTotalSales(List<CustomerOrder> orderDetails) {
        double sales = 0;
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new Date();
        for(CustomerOrder order : orderDetails){
            if(!order.getOrderStatus().equals("Order Awaiting Confirmation") && order.getOrderDate().equals(dateFormat.format(date))){
                sales += order.getOrderTotal();
            }
        }
        OrderStatsDaily orderStatsDaily = new OrderStatsDaily();
        orderStatsDaily.setToday(dateFormat.format(date));
        orderStatsDaily.setSales(sales);
        List<OrderStatsDaily> orderStatsDailies = getAllOrderStats();
        if(sales != orderStatsDailies.get(orderStatsDailies.size()-1).getSales()){
            addOrderStats(orderStatsDaily);
        }
    }
}
