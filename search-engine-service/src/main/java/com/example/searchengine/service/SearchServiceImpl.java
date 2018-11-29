package com.example.searchengine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.searchengine.response.Employee;

@Service
//
public class SearchServiceImpl implements SearchService {

    // autowire dao accordingly

    @Override
    public List<Employee> getEmployeeDetails(String company) {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee("Rahul", "Dravid", "abc@example.com", 23);
        Employee emp2 = new Employee("Sachin", "Tendulkar", "def@example.com", 27);

        employees.add(emp1);
        employees.add(emp2);

        return employees;
    }

    @Override
    public void onboardEmployee(Employee employee, String company) {

        // TODO PRI 20181119 Implement me!
    }
}
