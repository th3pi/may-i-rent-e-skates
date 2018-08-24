package com.mayi.controller;

import com.mayi.dao.ProductDao;
import com.mayi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ProductViewController {
    @Autowired
    private ProductDao productDao;

//    @RequestMapping("/")
//    public String home(){
//        return "home";
//    }

    @RequestMapping("/productList")
    public String getProducts(Model model) throws SQLException {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productID}")
    public String viewProduct(@PathVariable String productID, Model model) throws IOException {
        Product product = productDao.getProductById(productID);
        model.addAttribute(product);
        return "viewProduct";
    }
}
