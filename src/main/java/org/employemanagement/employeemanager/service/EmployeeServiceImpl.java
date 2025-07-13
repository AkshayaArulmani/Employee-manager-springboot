package org.employemanagement.employeemanager.service;

import org.employemanagement.employeemanager.model.Employee;
import org.employemanagement.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Long id,Employee updateEmployee) {
        Employee existing = employeeRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setFirstName(updateEmployee.getFirstName());
            existing.setLastName(updateEmployee.getLastName());
            existing.setEmail(updateEmployee.getEmail());
            existing.setDepartment(updateEmployee.getDepartment());
            existing.setSalary(updateEmployee.getSalary());
            existing.setPosition(updateEmployee.getPosition());
            return employeeRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
