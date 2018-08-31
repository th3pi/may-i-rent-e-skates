package com.mayi.service;


import com.mayi.model.Customer;
import com.mayi.model.CustomerOrder;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);
}
