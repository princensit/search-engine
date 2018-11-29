package com.example.searchengine.service;

import java.util.List;

import com.example.searchengine.response.Employee;

/**
 * <p>
 * <strong>Search Service</strong>
 * </p>
 *
 * <p>
 * <strong>Sample Code:</strong>
 * </p>
 *
 * <pre>
 *     ...
 * </pre>
 *
 * @author Prince Raj (email id)
 *
 * @since v1.0
 */
public interface SearchService {

    /**
     * Returns list of employee details for given company
     *
     * @param company company name
     * @return list of {@link Employee}
     */
    List<Employee> getEmployeeDetails(String company);

    /**
     * On-board new employee to company
     *
     * @param employee employee details {@link Employee}
     * @param company company name
     */
    void onboardEmployee(Employee employee, String company);
}
