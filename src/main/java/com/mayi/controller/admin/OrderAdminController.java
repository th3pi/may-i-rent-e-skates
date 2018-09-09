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
    private OrderDetailsService orderDetailsService;

    /**
     * This method simply fetches the order and order details from the database.
     * @param id is passed as the customer order id
     * @param model passes all the orderdetails and order attributes the view order for view.
     * @return the view order page.
     */


    @RequestMapping("/order/viewOrder/{id}")
    public String getOrder(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        List<OrderDetails> orderDetails = orderDetailsService.getAllOrderDetailsByOrderId(customerOrder.getCustomerOrderId());
        model.addAttribute("od",orderDetails);
        model.addAttribute("order",customerOrder);
        return "viewOrder";
    }

    /**
     * This method marks the order as picked up.
     * @param id is the customer order id
     * @param model not used at this moment
     * @return redirects to the same page to refresh order status
     */

    @RequestMapping("/order/markOrderAsPicked/{id}")
    public String markOrderAsPickedUp(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Order Picked Up");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }


    /**
     * This method marks the order as payment received.
     * @param id is the customer order id
     * @param model not used at this moment
     * @return redirects to the same page to refresh order status
     */

    @RequestMapping("/order/markOrderAsPaymentReceived/{id}")
    public String markOrderAsPaymentReceived(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Payment Received");
        OrderDetails orderDetails = orderDetailsService.getOrderDetailsByOrderId(customerOrder.getCustomerOrderId());
        Customer customer = customerOrder.getCustomer();
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }


    /**
     * This method marks the order as awaiting return.
     * @param id is the customer order id
     * @param model not used at this moment
     * @return redirects to the same page to refresh order status
     */

    @RequestMapping("/order/markOrderAsAwaitingReturn/{id}")
    public String markOrderAsAwaitingReturn(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Awaiting Return");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }


    /**
     * This method marks the order as completed.
     * @param id is the customer order id
     * @param model not used at this moment
     * @return redirects to the same page to refresh order status
     */

    @RequestMapping("/order/markOrderAsCompleted/{id}")
    public String markOrderAsCompleted(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Completed");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }

    /**
     * This method marks the order as cancelled up.
     * @param id is the customer order id
     * @param model not used at this moment
     * @return redirects to the same page to refresh order status
     */

    @RequestMapping("/order/markOrderAsCancelled/{id}")
    public String markOrderAsCancelled(@PathVariable int id, Model model){
        CustomerOrder customerOrder = customerOrderService.getCustomerOrderById(id);
        customerOrder.setOrderStatus("Cancelled");
        customerOrderService.updateOrderStatus(customerOrder);
        return "redirect:/admin/manageOrders";
    }
}
