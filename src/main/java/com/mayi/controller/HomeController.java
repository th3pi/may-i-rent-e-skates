package com.mayi.controller;

import com.mayi.model.Product;
import com.mayi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String home(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products",products);
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false)String error, @RequestParam(value = "logout", required = false)String logout, Model model){
        if(error != null){
            model.addAttribute("error","Invalid username or password");
        }

        if(logout != null){
            model.addAttribute("msg","You have been logged out successfully.");
        }

        return "login";
    }
}
