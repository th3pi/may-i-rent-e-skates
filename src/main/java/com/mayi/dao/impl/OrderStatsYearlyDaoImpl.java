package com.mayi.dao.impl;


import com.mayi.dao.OrderStatsYearlyDao;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.model.OrderStatsYearly;
import com.mayi.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
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
//
//        Query query = session.createQuery("from " +
//                "(select productId, count(*) " +
//                "from OrderDetails" +
//                "group by productId" +
//                "order by productId asc)");
//        List<Product> hottestProductList = query.list();
//
//        Product hottestProduct = hottestProductList.get(0);

        for(CustomerOrder orderDetails1 : orderDetails){
            if(!orderDetails1.getOrderStatus().equals("Order Awaiting Confirmation")) {
                sales += orderDetails1.getOrderTotal();
            }
        }
        OrderStatsYearly orderStats = new OrderStatsYearly();
        DateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date date = new Date();
//        orderStats.setMostPopularProduct(hottestProduct);
        orderStats.setYear(dateFormat.format(date));
        orderStats.setSales(sales);
        Query query = session.createQuery("from OrderStatsYearly");
        List<OrderStatsYearly> previousStats = query.list();
        if(sales != previousStats.get(previousStats.size()-1).getSales()){
            addOrderStats(orderStats);
        }
    }

    public void deleteOrderStats(OrderStatsYearly orderStats) {

    }
}
