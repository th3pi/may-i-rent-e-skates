package com.mayi.dao.impl;

import com.mayi.dao.ConnectDAO;
import com.mayi.dao.ProductDao;
import com.mayi.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

/**
 * Created by Le on 1/6/2016.
 */

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    public Product getProductById(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        session.flush();

        return product;
    }

    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    public void deleteProduct (String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductById(id));
        session.flush();
    }
}
