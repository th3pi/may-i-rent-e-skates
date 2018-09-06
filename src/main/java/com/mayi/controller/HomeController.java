package com.mayi.controller;

import com.mayi.model.OrderStatsDaily;
import com.mayi.model.OrderStatsMonthly;
import com.mayi.model.OrderStatsYearly;
import com.mayi.model.Product;
import com.mayi.service.OrderStatsDailyService;
import com.mayi.service.OrderStatsMonthlyService;
import com.mayi.service.OrderStatsYearlyService;
import com.mayi.service.ProductService;
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
    private OrderStatsDailyService orderStatsDailyService;

    @Autowired
    private OrderStatsMonthlyService orderStatsMonthlyService;

    @Autowired
    private OrderStatsYearlyService orderStatsYearlyService;
    
    @RequestMapping("/")
    public String home(Model model){
        List<Product> products = productService.getProductList();
        DateFormat todayFormat = new SimpleDateFormat("MM/dd/YYYY");
        DateFormat monthFormat = new SimpleDateFormat("MM");
        DateFormat yearFormat = new SimpleDateFormat("YYYY");
        List<OrderStatsDaily> orderStatsDailies = orderStatsDailyService.getAllOrderStats();
        List<OrderStatsMonthly> orderStatsMonthlies = orderStatsMonthlyService.getAllOrderStats();
        List<OrderStatsYearly> orderStatsYearlies = orderStatsYearlyService.getAllOrderStats();

        if(!orderStatsDailies.get(orderStatsDailies.size()-1).getToday().equals(todayFormat.format(new Date()))){
            OrderStatsDaily orderStatsDaily = new OrderStatsDaily();
            orderStatsDaily.setSales(0);
            orderStatsDaily.setToday(todayFormat.format(new Date()));
            orderStatsDailyService.addOrderStats(orderStatsDaily);
        }

        if(!orderStatsMonthlies.get(orderStatsMonthlies.size()-1).getMonth().equals(monthFormat.format(new Date()))){
            OrderStatsMonthly orderStatsMonthly = new OrderStatsMonthly();
            orderStatsMonthly.setSales(0);
            orderStatsMonthly.setMonth(monthFormat.format(new Date()));
            orderStatsMonthlyService.addOrderStats(orderStatsMonthly);
        }

        if(!orderStatsYearlies.get(orderStatsYearlies.size()-1).getYear().equals(yearFormat.format(new Date()))){
            OrderStatsYearly orderStatsYearly = new OrderStatsYearly();
            orderStatsYearly.setSales(0);
            orderStatsYearly.setYear(todayFormat.format(new Date()));
            orderStatsYearlyService.addOrderStats(orderStatsYearly);
        }
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
