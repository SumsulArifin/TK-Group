package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.DivisionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DivisionService {

    MessageResponse saveDivision(DivisionRequest divisionRequest);

    public Optional<Division> updateDivision(int divisionId, DivisionRequest division);

    public void deleteDivisionById(int divisionId);

    public Optional<Division> updateDivisionStatus(int divisionId, DivisionRequest division);

    List<Division> findSortedDivisionByKey(String field);

    public List<Division> getAllDivision();

    public Division findDivisionById(int divisionId);

}
