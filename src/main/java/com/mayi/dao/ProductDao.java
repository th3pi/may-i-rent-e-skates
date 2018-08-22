package com.mayi.dao;

import com.mayi.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    Product getProductById(String id);

    List<Product> getAllProducts() throws SQLException;

    void deleteProduct(String id);

    void editProduct(Product product);
}
