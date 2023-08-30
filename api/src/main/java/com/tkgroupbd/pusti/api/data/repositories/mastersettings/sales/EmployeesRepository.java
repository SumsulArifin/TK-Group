package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;
import com.tkgroupbd.pusti.api.data.models.enums.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {
        List<Employee> findByEmployeeType(EmployeeType employeeType);

}
