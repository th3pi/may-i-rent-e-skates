package com.mayi.dao;

import com.mayi.model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct(Product product);

    Product getProductByID(String id);

    List<Product> getAllProducts();

    void deleteProduct(String id);
}
