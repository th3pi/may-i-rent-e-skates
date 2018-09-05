package com.mayi.controller.admin;

import com.mayi.model.*;
import com.mayi.service.*;
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

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private OrderStatsYearlyService orderStatsYearlyService;

    @RequestMapping
    public String adminPage(Model model){
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        orderStatsYearlyService.getTotalSalesYTD(customerOrders);
        OrderStatsYearly orderStatsYearly = orderStatsYearlyService.getOrderStatsByDate("2018");
        model.addAttribute(orderStatsYearly);
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

    @RequestMapping("/manageOrders")
    public String manageOrders(Model model){
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        model.addAttribute("orders",customerOrders);

        return "manageOrders";
    }

    @RequestMapping("/customer")
    public String customerManagement(Model model){
        return "customerManagement";
    }


}
