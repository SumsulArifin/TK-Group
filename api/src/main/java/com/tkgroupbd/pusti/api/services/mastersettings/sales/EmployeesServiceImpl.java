package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.EmployeeRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.EmployeesRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeeService {
    @Autowired
    EmployeesRepository employeesRepository;

    @Override
    public MessageResponse saveEmployee(EmployeeRequest employeesRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setEmployeeType(employeesRequest.getEmployeeType());
        newEmployee.setDealingAreaId(employeesRequest.getDealingAreaId());
        newEmployee.setSalesOrgId(employeesRequest.getSalesOrgId());
        newEmployee.setMobile(employeesRequest.getMobile());
        newEmployee.setDepotId(employeesRequest.getDepotId());
        newEmployee.setBackPermit(employeesRequest.getBackPermit());
        newEmployee.setDesignationId(employeesRequest.getDesignationId());
        newEmployee.setDateOfJoining(employeesRequest.getDateOfJoining());
        newEmployee.setDateOfResignation(employeesRequest.getDateOfResignation());
        newEmployee.setBasicSalary(employeesRequest.getBasicSalary());
        newEmployee.setHouseRent(employeesRequest.getHouseRent());
        newEmployee.setMedicalAllowance(employeesRequest.getMedicalAllowance());
        newEmployee.setInternetBills(employeesRequest.getInternetBills());
        newEmployee.setOtherAllowance(employeesRequest.getOtherAllowance());
        newEmployee.setSscPassingYear(employeesRequest.getSscPassingYear());
        newEmployee.setHighestDegreeName(employeesRequest.getHighestDegreeName());
        newEmployee.setDateOfBirth(employeesRequest.getDateOfBirth());
        newEmployee.setBloodGroup(employeesRequest.getBloodGroup());
        newEmployee.setBankId(employeesRequest.getBankId());
        newEmployee.setBackAccNumber(employeesRequest.getBackAccNumber());
        newEmployee.setDistrictId(employeesRequest.getDistrictId());
        newEmployee.setEmail(employeesRequest.getEmail());
        newEmployee.setNid(employeesRequest.getNid());
        newEmployee.setTravellingDailyAllowance(employeesRequest.getTravellingDailyAllowance());
        newEmployee.setMeetingTravellingAllowance(employeesRequest.getMeetingTravellingAllowance());
        newEmployee.setMeetingDailyAllowance(employeesRequest.getMeetingDailyAllowance());
        newEmployee.setTravellingDailyAllowance(employeesRequest.getTravellingDailyAllowance());
        newEmployee.setStatus(employeesRequest.isStatus());
        newEmployee.setCreatedAt(employeesRequest.getCreatedAt());
        newEmployee.setUpdatedAt(employeesRequest.getUpdatedAt());
        newEmployee.setDeletedAt(employeesRequest.getDeletedAt());
        newEmployee.setBrowser(employeesRequest.getBrowser());
        newEmployee.setIp(employeesRequest.getIp());

        employeesRepository.save(newEmployee);
        return new MessageResponse(Message.SUCCESS_CREATION);
    }

    @Override
    public Optional<Employee> updateEmployee(int id, EmployeeRequest employeesRequest) {
        Optional<Employee> result = employeesRepository.findById(id);

        if (result.isPresent()) {
            Employee newEmployee = result.get();
            newEmployee.setEmployeeType(employeesRequest.getEmployeeType());
            newEmployee.setDealingAreaId(employeesRequest.getDealingAreaId());
            newEmployee.setSalesOrgId(employeesRequest.getSalesOrgId());
            newEmployee.setMobile(employeesRequest.getMobile());
            newEmployee.setDepotId(employeesRequest.getDepotId());
            newEmployee.setBackPermit(employeesRequest.getBackPermit());
            newEmployee.setDesignationId(employeesRequest.getDesignationId());
            newEmployee.setDateOfJoining(employeesRequest.getDateOfJoining());
            newEmployee.setDateOfResignation(employeesRequest.getDateOfResignation());
            newEmployee.setBasicSalary(employeesRequest.getBasicSalary());
            newEmployee.setHouseRent(employeesRequest.getHouseRent());
            newEmployee.setMedicalAllowance(employeesRequest.getMedicalAllowance());
            newEmployee.setInternetBills(employeesRequest.getInternetBills());
            newEmployee.setOtherAllowance(employeesRequest.getOtherAllowance());
            newEmployee.setSscPassingYear(employeesRequest.getSscPassingYear());
            newEmployee.setHighestDegreeName(employeesRequest.getHighestDegreeName());
            newEmployee.setDateOfBirth(employeesRequest.getDateOfBirth());
            newEmployee.setBloodGroup(employeesRequest.getBloodGroup());
            newEmployee.setBankId(employeesRequest.getBankId());
            newEmployee.setBackAccNumber(employeesRequest.getBackAccNumber());
            newEmployee.setDistrictId(employeesRequest.getDistrictId());
            newEmployee.setEmail(employeesRequest.getEmail());
            newEmployee.setNid(employeesRequest.getNid());
            newEmployee.setTravellingDailyAllowance(employeesRequest.getTravellingDailyAllowance());
            newEmployee.setMeetingTravellingAllowance(employeesRequest.getMeetingTravellingAllowance());
            newEmployee.setMeetingDailyAllowance(employeesRequest.getMeetingDailyAllowance());
            newEmployee.setTravellingDailyAllowance(employeesRequest.getTravellingDailyAllowance());
            newEmployee.setStatus(employeesRequest.isStatus());
            newEmployee.setCreatedAt(employeesRequest.getCreatedAt());
            newEmployee.setUpdatedAt(employeesRequest.getUpdatedAt());
            newEmployee.setDeletedAt(employeesRequest.getDeletedAt());
            newEmployee.setBrowser(employeesRequest.getBrowser());
            newEmployee.setIp(employeesRequest.getIp());

            employeesRepository.save(newEmployee);
        } else {
            throw new ResourceNotFoundException("Employees", "id", id);
        }

        return result;
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeesRepository.deleteById(id);
    }

    @Override
    public Optional<Employee> updateEmployeeStatus(int id, EmployeeRequest employeesRequest) {
        Optional<Employee> result = employeesRepository.findById(id);
        if (result.isPresent()) {
            Employee employees = result.get();
            employees.setStatus(employees.isStatus());
            employeesRepository.save(employees);
        } else {
            throw new ResourceNotFoundException("Employees", "id", id);
        }

        return result;
    }

    @Override
    public List<Employee> findSortedEmployeeByKey(String field) {
        return employeesRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeesRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeesRepository.findById(id).get();
    }

}
