package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.DivisionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.DivisionRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    DivisionRepository divisionRepository;

    @Override
    public MessageResponse saveDivision(DivisionRequest divisionRequest) {
        Division newDivision = new Division();
        newDivision.setDivisionName(divisionRequest.getDivisionName());
        newDivision.setStatus(divisionRequest.isStatus());
        newDivision.setCreatedBy(divisionRequest.getCreatedBy());
        newDivision.setUpdatedBy(divisionRequest.getUpdatedBy());
        newDivision.setCreatedAt(divisionRequest.getCreatedAt());
        newDivision.setUpdatedAt(divisionRequest.getUpdatedAt());
        newDivision.setDeletedAt(divisionRequest.getDeletedAt());
        newDivision.setBrowser(divisionRequest.getBrowser());
        newDivision.setIp(divisionRequest.getIp());

        divisionRepository.save(newDivision);
        return new MessageResponse(Message.SUCCESS_BANK_CREATION);
    }

    @Override
    public void deleteDivisionById(int divisionId) {

        divisionRepository.deleteById(divisionId);
    }

    @Override
    public Optional<Division> updateDivisionStatus(int divisionId, DivisionRequest divisionRequest) {
        Optional<Division> result = divisionRepository.findById(divisionId);
        if (result.isPresent()) {
            Division division = result.get();
            division.setStatus(division.isStatus());
            divisionRepository.save(division);
        } else {
            throw new ResourceNotFoundException("Division", "divisionId", divisionId);
        }

        return result;
    }

    @Override
    public List<Division> getAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> updateDivision(int divisionId, DivisionRequest divisionRequest) {
        Optional<Division> result = divisionRepository.findById(divisionId);

        if (result.isPresent()) {
            Division division = result.get();
            division.setDivisionName(divisionRequest.getDivisionName());
            division.setStatus(divisionRequest.isStatus());
            division.setCreatedAt(divisionRequest.getCreatedAt());
            division.setUpdatedAt(divisionRequest.getUpdatedAt());
            division.setDeletedAt(divisionRequest.getDeletedAt());
            division.setBrowser(divisionRequest.getBrowser());
            division.setIp(divisionRequest.getIp());

            divisionRepository.save(division);
        } else {
            throw new ResourceNotFoundException("Division", "divisionId", divisionId);
        }

        return result;
    }

    @Override
    public Division findDivisionById(int divisionId) {
        return divisionRepository.findById(divisionId).get();
    }

    @Override
    public List<Division> findSortedDivisionByKey(String field) {
        return divisionRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }
}
