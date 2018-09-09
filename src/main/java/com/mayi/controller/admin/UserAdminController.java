package com.mayi.controller.admin;

import com.mayi.model.*;
import com.mayi.service.CustomerOrderService;
import com.mayi.service.CustomerService;
import com.mayi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/manageUsers")
public class UserAdminController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerOrderService customerOrderService;

    /**
     * Initializes a new customer, shipping address and billing address object. This method only adds users with admin access.
     * To add a regular customer use addUser method.
     * @param model add the employee attributes to the page
     * @return loads the addEmployee form/page.
     */

    @RequestMapping("/employee/addEmployee")
    public String addEmployee(Model model){
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("employee",customer);
        return "addEmployee";
    }

    /**
     * This POST method checks for errors and adds user to the database
     * @param customer gets the customer in context
     * @param result checks for errors
     * @param model adds attirbute tothe page
     * @return redirects the manage users page.
     */

    @RequestMapping(value = "/employee/addEmployee",method = RequestMethod.POST)
    public String addEmployeePost(@Valid @ModelAttribute("employee") Customer customer, BindingResult result, Model model){
        if(result.hasErrors()){
            return "addEmployee";
        }

        List<Customer> customerList = customerService.getAllCustomers();
        for(Customer customer1 : customerList){
            if(customer.getCustomerEmail().equals(customer1.getCustomerEmail())){
                model.addAttribute("emailMsg", "Email already exists");

                return "addEmployee";
            }

            if(customer.getUsername().equals(customer1.getUsername())){
                model.addAttribute("userNameMsg", "Username already exists");

                return "addEmployee";
            }
        }
        customer.setUsername(customer.getCustomerEmail());
        customer.setEnabled(1);
        employeeService.addEmployee(customer);
        return "redirect:/admin/manageUsers";
    }

    /**
     * Initializes a new customer, shipping address and billing address object.
     * To add a regular customer use addUser method.
     * @param model add the user attributes to the page
     * @return loads the addUser form/page.
     */

    @RequestMapping("/user/addUser")
    public String addUser(Model model){
        Customer customer = new Customer();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        customer.setBillingAddress(billingAddress);
        customer.setShippingAddress(shippingAddress);
        model.addAttribute("customer",customer);
        return "addUser";
    }

    /**
     * This POST method checks for errors and adds user to the database
     * @param customer gets the customer in context
     * @param result checks for errors
     * @param model adds attirbute tothe page
     * @return redirects the manage users page.
     */

    @RequestMapping(value = "/user/addUser", method = RequestMethod.POST)
    public String addUserPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model){
        if(result.hasErrors()){
            return "addUser";
        }

        List<Customer> customerList = customerService.getAllCustomers();

        for(Customer customer1 : customerList){
            if(customer.getCustomerEmail().equals(customer1.getCustomerEmail())){
                model.addAttribute("emailMsg", "Email already exists");

                return "addUser";
            }

            if(customer.getUsername().equals(customer1.getUsername())){
                model.addAttribute("userNameMsg", "Username already exists");

                return "addUser";
            }
        }

        if(customer.getPassword().length() < 6){
            model.addAttribute("pwMsg","Minimum 6 characters password required.");
            return "addUser";
        }
        customer.setUsername(customer.getCustomerEmail());
        customer.setEnabled(1);
        customerService.addCustomer(customer);
        return "redirect:/admin/manageUsers";
    }

    /**
     * Edits user details pre-filled with details.
     * @param id gets the contextual user id
     * @param model adds the user attritbutes
     * @return loads the edit page for the user
     */
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

    /**
     * Saves the edits to the database, checks for errors.
     * @param customer gets the current customer
     * @param result checks for errors
     * @param model not used atm
     * @return redirects to the manage users page once done.
     */

    @RequestMapping(value = "/user/editUser", method = RequestMethod.POST)
    public String editUsersPost(@Valid @ModelAttribute("customer")Customer customer, BindingResult result, Model model){
        if(result.hasErrors()){
            return "editUser";
        }
        customerService.editCustomer(customer);
        return "redirect:/admin/manageUsers";
    }

    /**
     * This method views the user profile from admin perspective
     * @param customerId gets the contextual customer eid
     * @param model adds the customer details to the page.
     * @return the user profile.
     */

    @RequestMapping("/user/viewUser/{customerId}")
    public String getProfileRedirect(@PathVariable(value = "customerId") int customerId, Model model) {
        List<CustomerOrder> customerOrders = customerOrderService.getAllCustomerOrdersById(customerId);
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer",customer);
        model.addAttribute("orders",customerOrders);

        return "viewUser";
    }
}
