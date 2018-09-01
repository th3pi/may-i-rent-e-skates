package com.mayi.controller.admin;

import com.mayi.model.CustomerOrder;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/manageOrders")
public class OrderAdminController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @RequestMapping("/order/{id}")
    public String getOrder(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        model.addAttribute("order",customerOrder);
        return "viewOrder";
    }
}
