package com.mayi.controller.admin;

import com.mayi.model.Customer;
import com.mayi.model.CustomerOrder;
import com.mayi.model.OrderDetails;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.CustomerService;
import com.mayi.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/manageOrders")
public class OrderAdminController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @RequestMapping("/order/viewOrder/{id}")
    public String getOrder(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        List<OrderDetails> orderDetails = orderDetailsService.getAllOrderDetailsByOrderId(customerOrder.getCustomerOrderId());
        model.addAttribute("od",orderDetails);
        model.addAttribute("order",customerOrder);
        return "viewOrder";
    }

    @RequestMapping("/order/markOrderAsPicked/{id}")
    public String markOrderAsPickedUp(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Order Picked Up");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }

    @RequestMapping("/order/markOrderAsPaymentReceived/{id}")
    public String markOrderAsPaymentReceived(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Payment Received");
        Customer customer = customerOrder.getCustomer();
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }

    @RequestMapping("/order/markOrderAsAwaitingReturn/{id}")
    public String markOrderAsAwaitingReturn(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Awaiting Return");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }

    @RequestMapping("/order/markOrderAsCompleted/{id}")
    public String markOrderAsCompleted(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Completed");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }

    @RequestMapping("/order/markOrderAsCancelled/{id}")
    public String markOrderAsCancelled(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Cancelled");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }
}
