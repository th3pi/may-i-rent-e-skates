package com.mayi.controller;

import com.mayi.model.BillingAddress;
import com.mayi.model.Customer;
import com.mayi.model.ShippingAddress;
import com.mayi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Initializes the customer details.
     * @param model creates the customer
     * @return registration page
     */

    @RequestMapping("/register")
    public String registerCustomer(Model model){
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);

        model.addAttribute("customer",customer);

        return "registerCustomer";
    }

    /**
     * Adds customer to the database.
     * @param customer gets the filled form data
     * @param result gets errors
     * @param model adds attributes to the page
     * @return takes to the registration success view
     */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model, HttpServletRequest request){
        if(result.hasErrors()){
            return "registerCustomer";
        }

        List<Customer> customerList = customerService.getAllCustomers();

        for(Customer customer1 : customerList){
            if(customer.getCustomerEmail().equals(customer1.getCustomerEmail())){
                model.addAttribute("emailMsg", "Email already exists");

                return "registerCustomer";
            }

            if(customer.getUsername().equals(customer1.getUsername())){
                model.addAttribute("userNameMsg", "Username already exists");

                return "registerCustomer";
            }
        }

        if(customer.getPassword().length() <= 6){
            model.addAttribute("pwMsg","Minimum 6 characters password required.");
            return "registerCustomer";
        }
        customer.setUsername(customer.getCustomerEmail());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setEnabled(1);
        customerService.addCustomer(customer);
        try {
            request.login(customer.getUsername(),customer.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }

        return "registrationSuccess";
    }
}
