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

    @RequestMapping("/shop/skateboards")
    public String getSkateboards(Model model){
        List<Product> products = productService.getProductsByType("Skateboard");
        model.addAttribute("skateboards",products);
        return "skateboards";
    }
    
    @RequestMapping("/shop/scooters")
    public String getScooters(Model model){
        List<Product> products = productService.getProductsByType("Scooter");
        model.addAttribute("scooters",products);
        return "scooters";
    }

    @RequestMapping("/shop/cycles")
    public String getCycles(Model model){
        List<Product> products = productService.getProductsByType("Bicycle");
        model.addAttribute("cycles",products);
        return "cycles";
    }

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException{
        Product product = productService.getProductById(productId);
        if(product.getProductType().equals("Skateboard")){
            List<Product> products = productService.getProductsByType("Skateboard");
            model.addAttribute("contextualProducts",products);
        }else if(product.getProductType().equals("Scooter")){
            List<Product> products = productService.getProductsByType("Scooter");
            model.addAttribute("contextualProducts",products);
        }else if(product.getProductType().equals("Bicycle")){
            List<Product> products = productService.getProductsByType("Scooter");
            model.addAttribute("contextualProducts",products);
        }
        model.addAttribute("product", product);
        return "viewProduct";
    }
}
