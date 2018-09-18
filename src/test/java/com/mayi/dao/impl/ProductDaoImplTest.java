package com.mayi.dao.impl;

import com.mayi.model.Product;
import com.mayi.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@ContextConfiguration(locations = "classpath:applicationContextTest.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDaoImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void addProduct() {
        Product product = new Product();
        product.setProductName("Tesla");
        product.setProductQuantity("20");
        productService.addProduct(product);
        assertEquals(10,productService.getProductList().size());
    }

    @Test
    public void editProductStatus() {
        Product product = productService.getProductById(1);
        product.setProductStatus("Inactive");
        productService.editProductStatus(product);
        assertEquals("Inactive",productService.getProductById(1).getProductStatus());
    }

    @Test
    public void getProductById() {
        assertEquals("Inactive",productService.getProductById(1).getProductStatus());
    }

    @Test
    public void getProductsByType() {
        assertEquals(1,productService.getProductsByType("Scooter").size());
    }

    @Test
    public void getProductList() {
        assertEquals(0,productService.getProductList().size());
    }

    @Test
    public void editProduct() {
        Product product = productService.getProductById(1);
        product.setProductStatus("Active");
        productService.editProductStatus(product);
        assertEquals("Active",productService.getProductById(1).getProductStatus());
    }

    @Test
    public void deleteProduct() {
        Product product = productService.getProductById(1);
        productService.deleteProduct(product);
        assertEquals(8,productService.getProductList().size());
    }
}