package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;
import com.tkgroupbd.pusti.api.data.models.enums.EmployeeType;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.EmployeeRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.EmployeesRepository;
import com.tkgroupbd.pusti.api.data.repositories.user.UserRepository;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Employee")
@RestController
@RequestMapping("/employee")
public class EmployeesController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    UserService userService;

    // Create a new Employee

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> employeesSave(@RequestBody EmployeeRequest employeesRequest) {
        MessageResponse newEmp = employeeService.saveEmployee(employeesRequest);
        return new ResponseEntity<>(newEmp, HttpStatus.CREATED);
    }

    // retrieve all Employee
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Update a Employee information
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Employee>> updateEmployees(@PathVariable Integer id,
            @RequestBody EmployeeRequest employeesRequest) {
        Optional<Employee> employees = employeeService.updateEmployee(id, employeesRequest);
        return new ResponseEntity<Optional<Employee>>(employees, HttpStatus.OK);
    }

    // Employee Status Change API
    @PutMapping("/statusChange/{id}")
    public ResponseEntity<Optional<Employee>> changeEmployeesStatus(@PathVariable Integer id,
            @RequestBody EmployeeRequest employeesRequest) {
        Optional<Employee> employees = employeeService.updateEmployeeStatus(id, employeesRequest);
        return new ResponseEntity<Optional<Employee>>(employees, HttpStatus.OK);
    }

    // Delete Employee by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeesById(@PathVariable("id") Integer id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // API to retrieve Employee by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") Integer id) {
        Employee employees = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // API for search by keyword

    @GetMapping("/getSortedByKey/{field}")
    private ApiResponse<List<Employee>> getSortedEmployeesByKey(@PathVariable String field) {
        List<Employee> employeesList = employeeService.findSortedEmployeeByKey(field);
        return new ApiResponse(employeesList.size(), employeesList);
    }

    // API for search by EmployeeType
    @GetMapping("empType/{employeeType}")
    public List<Employee> getEmpByEmpType(@PathVariable EmployeeType employeeType) {
        List<Employee> byEmployeeType = employeesRepository.findByEmployeeType(employeeType);
        return byEmployeeType;

    }

}
