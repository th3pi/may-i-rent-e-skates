package com.mayi.controller.admin;

import com.mayi.model.*;
import com.mayi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Autowired
    private OrderStatsMonthlyService orderStatsMonthlyService;

    @Autowired
    private OrderStatsDailyService orderStatsDailyService;

    @RequestMapping
    public String adminPage(Model model){
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        orderStatsYearlyService.getTotalSalesYTD(customerOrders);
        DateFormat yearFormat = new SimpleDateFormat("YYYY");
        OrderStatsYearly orderStatsYearly = orderStatsYearlyService.getOrderStatsByDate(yearFormat.format(new Date()));
        orderStatsMonthlyService.getTotalSales(customerOrders);
        DateFormat monthFormate = new SimpleDateFormat("MM");
        OrderStatsMonthly orderStatsMonthly = orderStatsMonthlyService.getOrderStatsByDate(monthFormate.format(new Date()));
        orderStatsDailyService.getTotalSales(customerOrders);
        DateFormat todayFormat = new SimpleDateFormat("MM/dd/YYYY");
        OrderStatsDaily orderStatsDaily = orderStatsDailyService.getOrderStatsByDate(todayFormat.format(new Date()));

        List<CustomerOrder> ordersCompleted = customerOrderService.getOrderStatus("Completed");
        List<CustomerOrder> ordersPending = customerOrderService.getOrderStatus("Order Awaiting Confirmation");
        List<CustomerOrder> ordersPickedUp = customerOrderService.getOrderStatus("Order Picked Up");
        List<CustomerOrder> ordersAwaitingReturn = customerOrderService.getOrderStatus("Awaiting Return");


        model.addAttribute("completed",ordersCompleted);
        model.addAttribute("pending",ordersPending);
        model.addAttribute("pickedup",ordersPickedUp);
        model.addAttribute("areturn",ordersAwaitingReturn);
        model.addAttribute(orderStatsDaily);
        model.addAttribute(orderStatsMonthly);
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
