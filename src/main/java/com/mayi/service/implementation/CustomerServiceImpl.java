package com.mayi.service.implementation;


import com.mayi.dao.CustomerDao;
import com.mayi.model.Customer;
import com.mayi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public void editCustomer(Customer customer) {
        customerDao.editCustomer(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.deleteCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {

        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {

        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername (String username) {
        return customerDao.getCustomerByUsername(username);
    }

    public void assignNewCart(Customer customer) {
        customerDao.assignNewCart(customer);
    }

    public Customer validate(int id) throws IOException {
        return customerDao.validate(id);
    }
}
