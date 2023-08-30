package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.DistributorsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.DistributorRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributorServiceImpl implements DistributorService {

    @Autowired
    DistributorRepository distributorRepository;

    @Override
    public MessageResponse saveDistributor(DistributorsRequest distributorsRequest) {
        Distributor distributor = new Distributor();
        distributor.setDepot_id(distributorsRequest.getDepot_id());
        distributor.setName(distributorsRequest.getName());
        distributor.setErp_id(distributorsRequest.getErp_id());
        distributor.setProprietor_name(distributorsRequest.getProprietor_name());
        distributor.setProprietor_dob(distributorsRequest.getProprietor_dob());
        distributor.setMobile(distributorsRequest.getMobile());
        distributor.setAddress(distributorsRequest.getAddress());
        distributor.setHas_pc(distributorsRequest.getHas_pc());
        distributor.setHas_printer(distributorsRequest.getHas_printer());
        distributor.setHas_live_app(distributorsRequest.getHas_live_app());
        distributor.setHas_direct_sale(distributorsRequest.getHas_direct_sale());
        distributor.setOpening_date(distributorsRequest.getOpening_date());
        distributor.setEmergency_contact_name(distributorsRequest.getEmergency_contact_name());
        distributor.setEmergency_contact_name(distributorsRequest.getEmergency_contact_number());
        distributor.setEmergency_person_relation(distributorsRequest.getEmergency_person_relation());
        distributor.setStatus(distributorsRequest.isStatus());
        distributor.setCreatedAt(distributorsRequest.getCreatedAt());
        distributor.setUpdatedAt(distributorsRequest.getUpdatedAt());
        distributor.setDeletedAt(distributorsRequest.getDeletedAt());
        distributor.setBrowser(distributorsRequest.getBrowser());
        distributor.setIp(distributorsRequest.getIp());
        distributor.setRoute(distributorsRequest.getRoute());

        distributorRepository.save(distributor);
        return new MessageResponse(Message.SUCCESS_CREATION);
    }

    @Override
    public Optional<Distributor> updateDistributor(int distributor_id, DistributorsRequest distributorsRequest) {
        Optional<Distributor> result = distributorRepository.findById(distributor_id);
        if (result.isPresent()) {
            Distributor objDistributor = result.get();
            objDistributor.setDepot_id(distributorsRequest.getDepot_id());
            objDistributor.setName(distributorsRequest.getName());
            objDistributor.setErp_id(distributorsRequest.getErp_id());
            objDistributor.setProprietor_name(distributorsRequest.getProprietor_name());
            objDistributor.setProprietor_dob(distributorsRequest.getProprietor_dob());
            objDistributor.setMobile(distributorsRequest.getMobile());
            objDistributor.setAddress(distributorsRequest.getAddress());
            objDistributor.setHas_pc(distributorsRequest.getHas_pc());
            objDistributor.setHas_printer(distributorsRequest.getHas_printer());
            objDistributor.setHas_live_app(distributorsRequest.getHas_live_app());
            objDistributor.setHas_direct_sale(distributorsRequest.getHas_direct_sale());
            objDistributor.setOpening_date(distributorsRequest.getOpening_date());
            objDistributor.setEmergency_contact_name(distributorsRequest.getEmergency_contact_name());
            objDistributor.setEmergency_contact_name(distributorsRequest.getEmergency_contact_number());
            objDistributor.setEmergency_person_relation(distributorsRequest.getEmergency_person_relation());
            objDistributor.setStatus(distributorsRequest.isStatus());
            objDistributor.setCreatedAt(distributorsRequest.getCreatedAt());
            objDistributor.setUpdatedAt(distributorsRequest.getUpdatedAt());
            objDistributor.setDeletedAt(distributorsRequest.getDeletedAt());
            objDistributor.setBrowser(distributorsRequest.getBrowser());
            objDistributor.setIp(distributorsRequest.getIp());
            objDistributor.setRoute(distributorsRequest.getRoute());

            distributorRepository.save(objDistributor);
        } else {
            throw new ResourceNotFoundException("Distributor", "distributor_id", distributor_id);
        }

        return result;
    }

    @Override
    public void deleteDistributorById(int distributor_id) {
        distributorRepository.deleteById(distributor_id);
    }

    @Override
    public Optional<Distributor> updateDistributorStatus(int distributor_id, DistributorsRequest distributorsRequest) {
        Optional<Distributor> distributor = distributorRepository.findById(distributor_id);
        if (distributor.isEmpty()) {
            throw new ResourceNotFoundException("Distributor", "distributor_id", distributor_id);
        } else
            distributor.get().setStatus(distributorsRequest.isStatus());
        ;
        distributorRepository.save(distributor.get());
        return distributor;
    }

    @Override
    public List<Distributor> findSortedDistributorByKey(String field) {
        return distributorRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public List<Distributor> getAllDistributor() {
        return distributorRepository.findAll();
    }

    @Override
    public Distributor findDistributorById(int distributor_id) {
        return distributorRepository.findById(distributor_id).get();
    }
}
