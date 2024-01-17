package com.example.spring_testing_demo.services;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees
    public Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    // Get one employee by id
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    // Create employee
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    // Update one employee
    public Employee updateEmployeeById(Long id, Employee employee){
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    // Delete one employee
    public boolean deleteEmployeeById(Long id){
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);
            return true;
        }

        return false;

    }

    public Iterable <Employee> seedEmployees(){

            Employee[] employees = {
                    new Employee("vigor", 100000),
                    new Employee("andreas", 100000),
                    new Employee("adam", 100000)
            };
            var employeesList = Arrays.stream(employees).toList();
            employeeRepository.saveAll(employeesList);
            return employeesList;
    }

}
