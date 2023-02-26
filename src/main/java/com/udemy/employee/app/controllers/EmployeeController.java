package com.udemy.employee.app.controllers;

import com.udemy.employee.app.entities.Employee;
import com.udemy.employee.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> findAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("employees")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
