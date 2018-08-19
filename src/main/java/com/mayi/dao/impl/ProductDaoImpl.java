package com.mayi.dao.impl;

import com.mayi.dao.ProductDao;
import com.mayi.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Product getProductByID(String id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class,id);
        session.flush();

        return product;
    }

    public List<Product> getAllProducts() {
//        List<Product> productList = new ArrayList<Product>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();
        return products;
    }

    public void deleteProduct(String id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getProductByID(id));
        session.flush();
    }
}
