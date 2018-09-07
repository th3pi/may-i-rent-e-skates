package com.mayi.controller;

import com.mayi.model.*;
import com.mayi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private OrderStatsDailyService orderStatsDailyService;

    @Autowired
    private OrderStatsMonthlyService orderStatsMonthlyService;

    @Autowired
    private OrderStatsYearlyService orderStatsYearlyService;

    /**The home controller creates a new empty entry in the database everyday to reset Today's sales.
     * Every month to reset this month's sales
     * Every year to reset this year's sales
     *
     */


    @RequestMapping("/")
    public String home(Model model){
        List<Product> products = productService.getProductList();
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrders();
        DateFormat todayFormat = new SimpleDateFormat("MM/dd/YYYY");
        Date date = new  Date();
        String currentDate = todayFormat.format(date);
        DateFormat monthFormat = new SimpleDateFormat("MM");
        String currentMonth = monthFormat.format(date);
        DateFormat yearFormat = new SimpleDateFormat("YYYY");
        String currentYear = yearFormat.format(date);

        //Gets all the order stats.

        List<OrderStatsDaily> orderStatsDailies = orderStatsDailyService.getAllOrderStats();
        List<OrderStatsMonthly> orderStatsMonthlies = orderStatsMonthlyService.getAllOrderStats();
        List<OrderStatsYearly> orderStatsYearlies = orderStatsYearlyService.getAllOrderStats();

        if(!orderStatsDailies.get(orderStatsDailies.size()-1).getToday().equals(currentDate)){
            OrderStatsDaily orderStatsDaily = new OrderStatsDaily();
            orderStatsDaily.setSales(0);
            orderStatsDaily.setToday(todayFormat.format(new Date()));
            orderStatsDailyService.addOrderStats(orderStatsDaily);
        }

        if(!orderStatsMonthlies.get(orderStatsMonthlies.size() - 1).getMonth().equals(currentMonth)){
            OrderStatsMonthly orderStatsMonthly = new OrderStatsMonthly();
            orderStatsMonthly.setSales(0);
            orderStatsMonthly.setMonth(currentMonth);
            orderStatsMonthlyService.addOrderStats(orderStatsMonthly);
        }

        if(!orderStatsYearlies.get(orderStatsYearlies.size()-1).getYear().equals(currentYear)){
            OrderStatsYearly orderStatsYearly = new OrderStatsYearly();
            orderStatsYearly.setSales(0);
            orderStatsYearly.setYear(currentYear);
            orderStatsYearlyService.addOrderStats(orderStatsYearly);
        }
        model.addAttribute("products",products);
        return "home";
    }

}
