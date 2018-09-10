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

    /**
     * Gets all yearly order stats. Be careful when using as it will increase load time dramatically.
     * @return the entire list of order stats.
     */

    public List<OrderStatsYearly> getAllOrderStats() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly");
        return query.list();
    }

    /**
     * Gets order stats by id. Irrelevant. I don't know why I created this.
     * @param id order stats id
     * @return the order stats.
     */

    public OrderStatsYearly getOrderStatsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly where orderStatsId = ?");
        query.setInteger(0,id);
        return (OrderStatsYearly) query.uniqueResult();
    }

    /**
     * Gets order stats based on product id. Useful to rank the most sold products of the year.
     * Not implemented fully yet.
     * @param id the product id.
     * @return the yearly stats of the product
     */

    public OrderStatsYearly getOrderStatsByProductId(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly where productId = ?");
        query.setInteger(0,id);
        return (OrderStatsYearly) query.uniqueResult();
    }

    /**
     * Gets yearly order stats by specific year
     * @param date the year to be queried
     * @return the stats for the year
     */

    public OrderStatsYearly getOrderStatsByDate(String date) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderStatsYearly where year = ?");
        query.setString(0,date);
        List<OrderStatsYearly> orderStatsYearlies = query.list();
        return orderStatsYearlies.get(orderStatsYearlies.size()-1);
    }

    /**
     * Adds order stats to the database. A new entity created every time there's a new order.
     * @param orderStats passed from controller. The orderStats to be added.
     */

    public void addOrderStats(OrderStatsYearly orderStats) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderStats);
        session.flush();
    }

    /**
     * Gets total sales of a certain year. Does not add to sales as long order status is Order Awaiting Confirmation.
     * Creates a new entity in the database for every sale as per business requirements. Keeps adding as long order status
     * is valid and the date is current date.
     * @param orderDetails passed from controller.
     */

    public void getTotalSalesYTD(List<CustomerOrder> orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        double sales = 0;
        DateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date = new Date();
        for(CustomerOrder orderDetails1 : orderDetails){
            if(!orderDetails1.getOrderStatus().equals("Order Awaiting Confirmation")) {
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

    /**
     * Irrelevant not implemented yet.
     * @param orderStats passed from controller.
     */

    public void deleteOrderStats(OrderStatsYearly orderStats) {

    }
}
