package com.mayi.dao.impl;


import com.mayi.dao.OrderDetailsDao;
import com.mayi.model.*;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.ProductService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerOrderService customerOrderService;


    public List<OrderDetails> getAllOrderDetails() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails");
        return query.list();
    }

    public OrderDetails getOrderDetailsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from OrderDetails where orderdetailsId = ?");
        query.setInteger(0,id);
        return (OrderDetails) query.uniqueResult();
    }

    public void addOrderDetails(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(orderDetails);
        session.flush();
    }

    public void insertNewProduct(int orderId) {
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(orderId);
        List<CartItem> cartItems = customerOrder.getCart().getCartItems();
        for(CartItem cartItem : cartItems){
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setProduct(cartItem.getProduct());
            orderDetails.setCustomerOrder(customerOrder);
            addOrderDetails(orderDetails);
        }
    }

    public void removeOrderDetails(OrderDetails orderDetails) {

    }
}
