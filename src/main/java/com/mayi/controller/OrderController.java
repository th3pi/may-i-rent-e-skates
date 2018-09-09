package com.mayi.controller;

import com.mayi.model.Cart;
import com.mayi.model.Customer;
import com.mayi.model.CustomerOrder;
import com.mayi.service.CartService;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.webflow.engine.model.Model;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    /**
     * Creates an order
     * @param cartId gets contextual cart id
     * @return starts the checkout web-flow
     */

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customerOrder.setShippingAddress(customer.getShippingAddress());
        customerOrderService.addCustomerOrder(customerOrder);
        orderDetailsService.insertNewProduct(customerOrder.getCustomerOrderId());



        return "redirect:/checkout?cartId="+cartId;
    }
}
