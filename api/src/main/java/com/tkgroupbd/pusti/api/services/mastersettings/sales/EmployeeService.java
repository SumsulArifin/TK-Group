package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.EmployeeRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
    MessageResponse saveEmployee(EmployeeRequest EmployeeRequest);

    public Optional<Employee> updateEmployee(int id, EmployeeRequest EmployeeRequest);

    public void deleteEmployeeById(int id);

    public Optional<Employee> updateEmployeeStatus(int id, EmployeeRequest EmployeeRequest);

    List<Employee> findSortedEmployeeByKey(String field);

    public List<Employee> getAllEmployee();

    public Employee findEmployeeById(int id);
    // public Employee findEmployeeByType(String employeeType);

}
