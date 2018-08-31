package com.mayi.controller.admin;

import com.mayi.model.Customer;
import com.mayi.model.Product;
import com.mayi.service.CustomerService;
import com.mayi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products",products);
        return "productInventory";
    }

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/manageUsers")
    public String manageUsers(Model model){
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("users",customerList);

        return "manageUsers";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model){
        return "customerManagement";
    }


}
