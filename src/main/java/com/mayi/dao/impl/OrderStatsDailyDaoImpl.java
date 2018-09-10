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

    /**
     * Gets order stats by specific date.
     * @param date string passed from controller
     * @return the last order stats created on the particular date.
     */

    public OrderStatsDaily getOrderStatsByDate(String date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsDaily where today = ?");
        query.setString(0,date);
        return (OrderStatsDaily) query.list().get(query.list().size()-1);
    }

    /**
     * Gets all daily order stats. Be careful when using as it will increase load time dramatically.
     * @return the entire list of order stats.
     */

    public List<OrderStatsDaily> getAllOrderStats() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsDaily");
        return query.list();
    }

    /**
     * Adds order stats to the database. A new entity created every time there's a new order.
     * @param orderStats passed from controller. The orderStats to be added.
     */

    public void addOrderStats(OrderStatsDaily orderStats) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderStats);
        session.flush();
    }

    /**
     * Gets first day of each month. Unused. Not sure if it would work.
     * @param dates array of dates passed from controller
     * @return the list of first days of months.
     */

    public List<OrderStatsDaily> getFirstDayOfEachMonth(String[] dates) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from orderStatsDaily where today = ?");
        query.setParameter(0,dates);
        return query.list();
    }

    /**
     * Gets total sales of a certain date. Does not add to sales as long order status is Order Awaiting Confirmation.
     * Creates a new entity in the database for every sale as per business requirements. Keeps adding as long order status
     * is valid and the date is current date.
     * @param orderDetails passed from controller.
     */

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
