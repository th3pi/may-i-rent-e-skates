package com.mayi.controller.admin;

import com.mayi.model.*;
import com.mayi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private OrderStatsYearlyService orderStatsYearlyService;

    @Autowired
    private OrderStatsMonthlyService orderStatsMonthlyService;

    @Autowired
    private OrderStatsDailyService orderStatsDailyService;

    /**
     *
     * Method admin page calculates and gets all the order statistics.
     *
     * @param model sends the order stats to the views
     * @return admin view
     */

    @RequestMapping
    public String adminPage(Model model){
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();

        //Gets yearly order stats
        orderStatsYearlyService.getTotalSalesYTD(customerOrders);
        DateFormat yearFormat = new SimpleDateFormat("YYYY");
        OrderStatsYearly orderStatsYearly = orderStatsYearlyService.getOrderStatsByDate(yearFormat.format(new Date()));

        //Gets monthly user stats
        orderStatsMonthlyService.getTotalSales(customerOrders);
        DateFormat monthFormat = new SimpleDateFormat("MM");
        OrderStatsMonthly orderStatsMonthly = orderStatsMonthlyService.getOrderStatsByDate(monthFormat.format(new Date()));
        orderStatsDailyService.getTotalSales(customerOrders);
        DateFormat todayFormat = new SimpleDateFormat("MM/dd/YYYY");
        OrderStatsDaily orderStatsDaily = orderStatsDailyService.getOrderStatsByDate(todayFormat.format(new Date()));

        /*
        * This chunk gets all the orders with a certain order status for the admin page stats.
         */
        List<CustomerOrder> ordersCompleted = customerOrderService.getOrderStatus("Completed");
        List<CustomerOrder> ordersPending = customerOrderService.getOrderStatus("Order Awaiting Confirmation");
        List<CustomerOrder> ordersPickedUp = customerOrderService.getOrderStatus("Order Picked Up");
        List<CustomerOrder> ordersAwaitingReturn = customerOrderService.getOrderStatus("Awaiting Return");
        List<OrderStatsMonthly> orderStatsMonthlies = orderStatsMonthlyService.getAllOrderStats();
        List<Double> perMonthSales = new ArrayList<Double>();

        for(int i = 0; i < orderStatsMonthlies.size(); i++){
            if(orderStatsMonthlies.get(i).getSales() == 0){
                perMonthSales.add(orderStatsMonthlies.get(i-1).getSales());
            }
        }


        model.addAttribute("completed",ordersCompleted);
        model.addAttribute("pending",ordersPending);
        model.addAttribute("pickedup",ordersPickedUp);
        model.addAttribute("areturn",ordersAwaitingReturn);
        model.addAttribute("perMonthSales",perMonthSales);
        model.addAttribute(orderStatsDaily);
        model.addAttribute(orderStatsMonthly);
        model.addAttribute(orderStatsYearly);
        return "admin";
    }

    /**
     * Sets up the product inventory page for admin
      * @param model gets all the product list
     * @return product inventory page
     */

    @RequestMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products",products);
        return "productInventory";
    }

    /**
     * Sets up the user management page for admin
     * @param model gets all the users currently registered
     * @return user management page
     */

    @RequestMapping("/manageUsers")
    public String manageUsers(Model model){
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("users",customerList);

        return "manageUsers";
    }

    /**
     * Sets up the order management page for admin
     * @param model gets all the orders
     * @return order management page
     */

    @RequestMapping("/manageOrders")
    public String manageOrders(Model model){
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        model.addAttribute("orders",customerOrders);

        return "manageOrders";
    }


}
