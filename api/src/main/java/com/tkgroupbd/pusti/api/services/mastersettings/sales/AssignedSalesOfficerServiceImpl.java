package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.AssignedSalesOfficer;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.AssignedSalesOfficerRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.AssignedSalesOfficerRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignedSalesOfficerServiceImpl implements AssignedSalesOfficerService {
    @Autowired
    AssignedSalesOfficerRepository assignedSalesOfficerRepository;

    @Override
    public MessageResponse saveAssignedSalesOfficer(AssignedSalesOfficerRequest assigned_sales_officerRequest) {
        AssignedSalesOfficer assigned_sales_officer = new AssignedSalesOfficer();
        assigned_sales_officer.setSoId(assigned_sales_officerRequest.getSoId());
        assigned_sales_officer.setStatus(assigned_sales_officerRequest.isStatus());
        assigned_sales_officer.setCreatedAt(assigned_sales_officerRequest.getCreatedAt());
        assigned_sales_officer.setUpdatedAt(assigned_sales_officerRequest.getUpdatedAt());
        assigned_sales_officer.setDeletedAt(assigned_sales_officerRequest.getDeletedAt());
        assigned_sales_officer.setBrowser(assigned_sales_officerRequest.getBrowser());
        assigned_sales_officer.setIp(assigned_sales_officerRequest.getIp());
        assigned_sales_officer.setRoute(assigned_sales_officerRequest.getRoute());

        assignedSalesOfficerRepository.save(assigned_sales_officer);
        return new MessageResponse(Message.SUCCESS_CREATION);
    }

    @Override
    public Optional<AssignedSalesOfficer> updateAssignedSalesOfficer(int assignedId,
            AssignedSalesOfficerRequest assigned_sales_officerRequest) {
        Optional<AssignedSalesOfficer> result = assignedSalesOfficerRepository.findById(assignedId);
        if (result.isPresent()) {
            AssignedSalesOfficer objAssignedSO = result.get();
            objAssignedSO.setSoId(assigned_sales_officerRequest.getSoId());
            objAssignedSO.setStatus(assigned_sales_officerRequest.isStatus());
            objAssignedSO.setCreatedAt(assigned_sales_officerRequest.getCreatedAt());
            objAssignedSO.setUpdatedAt(assigned_sales_officerRequest.getUpdatedAt());
            objAssignedSO.setDeletedAt(assigned_sales_officerRequest.getDeletedAt());
            objAssignedSO.setBrowser(assigned_sales_officerRequest.getBrowser());
            objAssignedSO.setIp(assigned_sales_officerRequest.getIp());
            objAssignedSO.setRoute(assigned_sales_officerRequest.getRoute());
            assignedSalesOfficerRepository.save(objAssignedSO);

        } else
            throw new ResourceNotFoundException("Assigned_Sales_Officer", "assignedId", assignedId);

        return result;
    }

    @Override
    public void deleteAssignedSalesOfficerById(int assignedId) {
        assignedSalesOfficerRepository.deleteById(assignedId);
    }

    @Override
    public Optional<AssignedSalesOfficer> updateAssignedSalesOfficerStatus(int assignedId,
            AssignedSalesOfficerRequest assigned_sales_officerRequest) {
        Optional<AssignedSalesOfficer> assignedSalesOfficer = assignedSalesOfficerRepository.findById(assignedId);
        if (assignedSalesOfficer.isEmpty()) {
            throw new ResourceNotFoundException("Assigned_Sales_Officer", "assignedId", assignedId);
        } else
            assignedSalesOfficer.get().setStatus(assigned_sales_officerRequest.isStatus());
        ;
        assignedSalesOfficerRepository.save(assignedSalesOfficer.get());
        return assignedSalesOfficer;
    }

    @Override
    public List<AssignedSalesOfficer> findSortedAssignedSalesOfficerByKey(String field) {
        return assignedSalesOfficerRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public List<AssignedSalesOfficer> getAllAssignedSalesOfficer() {
        return assignedSalesOfficerRepository.findAll();
    }

    @Override
    public AssignedSalesOfficer findAssignedSalesOfficerById(int assignedId) {
        return assignedSalesOfficerRepository.findById(assignedId).get();
    }

    @Override
    public List<AssignedSalesOfficer> getAssignedSalesOfficerListByRouteID(int route_id) {
        return null;// assignedSalesOfficerRepository.findAssignedSalesOfficerByRouteId(route_id);
    }
}
