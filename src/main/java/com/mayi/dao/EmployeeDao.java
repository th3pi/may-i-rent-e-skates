package com.mayi.dao;

import com.mayi.model.Customer;

public interface EmployeeDao {

    void addEmployee(Customer customer);

    void editEmployee(Customer customer);
}
