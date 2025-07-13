package org.employemanagement.employeemanager.service;

import org.employemanagement.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id,Employee employee);
    void deleteEmployeeById(Long id);
}
