package com.mayi.service;


import com.mayi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(int id);

    List<Product> getProductsByType(String type);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

    void editProductStatus(Product product);
}
