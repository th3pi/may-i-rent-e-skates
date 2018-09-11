package com.mayi.dao.impl;

import com.mayi.dao.ConnectDAO;
import com.mayi.dao.ProductDao;
import com.mayi.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
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

    /**
     * Adds product to the database
     * @param product the product to be added
     */

    public void addProduct(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    /**
     * Edits product status. Either Inactive or active. Active shows up in the store, inactive doesn't.
     * @param product the product's status to be edited.
     */

    public void editProductStatus(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    /**
     * Gets product with a specific product id from the database.
     * @param id the product to be fetched
     * @return the product that has been fetched
     */

    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        session.flush();

        return product;
    }

    /**
     * Gets product by a specific type. Used to filter the shop view
     * @param type the type of products to be queried for
     * @return products with the specific type
     */

    public List<Product> getProductsByType(String type){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product where productType = ?");
        query.setString(0,type);
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    /**
     * Gets all products currently stored in the database.
     * @return the list of products
     */

    public List<Product> getProductList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> products = query.list();
        session.flush();

        return products;
    }

    /**
     * Lets admin edit the product details.
     * @param product the product that's going to be edited.
     */

    public void editProduct(Product product){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();
    }

    /**
     * Lets admin delete a product. NOT RECOMMENDED.
     * @param product the product to be deleted.
     */

    public void deleteProduct (Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
    }
}
