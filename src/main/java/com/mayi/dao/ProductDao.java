package com.mayi.dao;

import com.mayi.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getProductsByType(String type);
}
