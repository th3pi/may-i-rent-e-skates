package com.mayi.service.implementation;

import com.mayi.dao.EmployeeDao;
import com.mayi.model.Customer;
import com.mayi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Customer customer) {
        employeeDao.addEmployee(customer);
    }

    public void editEmployee(Customer customer) {
        employeeDao.editEmployee(customer);
    }
}
