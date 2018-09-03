package com.mayi.controller;

import com.mayi.model.Customer;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.CustomerService;
import com.mayi.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class ProfileController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping("/profile")
    public String getProfile(@AuthenticationPrincipal User activeUser){
        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        int customerId = customer.getCustomerId();

        return "redirect:/user/profile/"+customerId;
    }

    @RequestMapping("/profile/{customerId}")
    public String getProfileRedirect(@PathVariable(value = "customerId") int customerId, Model model) {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrdersById(customerId);
        model.addAttribute("orders",customerOrders);

        return "profile";
    }

    @RequestMapping("/markOrderAsCancelled/{id}")
    public String markOrderAsCancelledAsACustomer(@PathVariable int id, @AuthenticationPrincipal User activeUser){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Cancelled");
        customerOrderService.updateOrderStatus(customerOrder);
        Customer customer = customerService.getCustomerByUsername (activeUser.getUsername());
        int customerId = customer.getCustomerId();
        return "redirect:/user/profile/"+customerId;
    }

    @RequestMapping("/viewOrder/{id}")
    public String getOrder(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        List<OrderDetails> orderDetails = orderDetailsService.getAllOrderDetailsByOrderId(customerOrder.getCustomerOrderId());
        model.addAttribute("od",orderDetails);
        model.addAttribute("order",customerOrder);
        return "viewOrder";
    }

}
