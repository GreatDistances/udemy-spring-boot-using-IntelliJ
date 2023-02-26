package com.udemy.employee.app.service;

import com.udemy.employee.app.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
        new Employee(1, "Matt", "St Louis"),
        new Employee(2, "Pravriti", "Darjeeling"),
        new Employee(3, "Igor", "Istanbul")
    ));

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int someId) {
        return employeeList.stream().filter(e -> (e.getId() == someId)).findFirst().get();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void updateEmployee(Employee employee) {
        for (Employee e : employeeList) {
            if (e.getId() == employee.getId()) {
                e.setName(employee.getName());
                e.setLocation(employee.getLocation());
            }
        }
    }

    public void deleteEmployee(int id) {
        employeeList.remove(getEmployeeById(id));
    }
}