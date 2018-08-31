package com.mayi.controller.admin;

import com.mayi.model.BillingAddress;
import com.mayi.model.Customer;
import com.mayi.model.ShippingAddress;
import com.mayi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/manageUsers")
public class UserAdminController {

    @Autowired
    private CustomerService customerService;

//    @RequestMapping("/manageUsers/deleteuser/{id}")
//    public String deleteUsers(@PathVariable int id, Model model){
//        Customer customer = customerService.getCustomerById(id);
//        customerService.deleteCustomer(customer);
//        return "redirect:/admin/manageUsers";
//    }

    @RequestMapping("/user/editUser/{id}")
    public String editUsers(@PathVariable int id, Model model){
        Customer customer = customerService.getCustomerById(id);
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setCustomer(customerService.getCustomerById(id));
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCustomer(customerService.getCustomerById(id));
        model.addAttribute("user",customer);
        return "editUser";
    }

    @RequestMapping(value = "/user/editUser", method = RequestMethod.POST)
    public String editUsersPost(@ModelAttribute("customer")Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "editUser";
        }
        customerService.editCustomer(customer);
        return "redirect:/admin/manageUsers";
    }
}
