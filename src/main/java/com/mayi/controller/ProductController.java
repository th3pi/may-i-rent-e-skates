package com.mayi.controller;

import com.mayi.model.Product;
import com.mayi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;


    @RequestMapping("/shop")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products",products);

        return "shop";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException{
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "viewProduct";
    }
}