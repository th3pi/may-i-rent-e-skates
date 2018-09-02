package com.mayi.dao;

import com.mayi.model.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerDao {

    void addCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    void assignNewCart(Customer customer);

    Customer validate(int id) throws IOException;

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
