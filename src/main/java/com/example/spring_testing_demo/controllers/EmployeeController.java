package com.example.spring_testing_demo.controllers;

import com.example.spring_testing_demo.models.Employee;
import com.example.spring_testing_demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    // GET: /api/employees
    @GetMapping
    public Iterable <Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // Get one employee by id
    // GET: /api/employees/{id}
    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    // Post one user / Create an employee
    // POST: /api/employees
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    // Put on user / Update an employee
    // PUT: /api/employees/{id}
    @PutMapping("/{id}")
    public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(id, employee);
    }

    // Delete one employee
    // DELETE: /api/employees/{id}
    @DeleteMapping("/{id}")
    public boolean deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployeeById(id);
    }

    @PostMapping("/seed")
    public boolean postSeedUsers() {
        return employeeService.seed();
    }

}
