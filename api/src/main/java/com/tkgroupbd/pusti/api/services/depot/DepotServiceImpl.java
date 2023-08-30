package com.tkgroupbd.pusti.api.services.depot;

import com.tkgroupbd.pusti.api.data.models.entity.depot.Depot;
import com.tkgroupbd.pusti.api.data.payloads.requests.depot.DepotRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.depot.DepotRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepotServiceImpl implements DepotService {
    @Autowired
    DepotRepository depotRepository;

    @Override
    public MessageResponse addDepot(DepotRequest depotRequest) {
        Depot newDepot = new Depot();
        newDepot.setName(depotRequest.getName());
        newDepot.setEmail(depotRequest.getEmail());
        newDepot.setPhone(depotRequest.getPhone());
        depotRepository.save(newDepot);
        return new MessageResponse(Message.SUCCESS_DEPOT_CREATION);
    }

    @Override
    public Optional<Depot> updateDepot(Integer depotId, DepotRequest depotRequest) {
        Optional<Depot> depot = depotRepository.findById(depotId);
        if (depot.isEmpty()) {
            throw new ResourceNotFoundException("Depot", "depotId", depotId);
        } else
            depot.get().setName(depotRequest.getName());
        depot.get().setEmail(depotRequest.getEmail());
        depot.get().setPhone(depotRequest.getPhone());
        depotRepository.save(depot.get());
        return depot;
    }

    @Override
    public void deleteDepot(Integer depotId) {
        depotRepository.deleteById(depotId);

    }

    @Override
    public Depot getDeportById(Integer depotId) {
        return depotRepository.findById(depotId)
                .orElseThrow(() -> new ResourceNotFoundException("Deport", "depotId", depotId));
    }

    @Override
    public List<Depot> getAllDepots() {
        return depotRepository.findAll();
    }

    @Override
    public List<Depot> findSortedDepotsByKey(String field) {
        return depotRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public Page<Depot> findDepotByPagination(int offset, int pageSize) {
        Page<Depot> depots = depotRepository.findAll(PageRequest.of(offset, pageSize));
        return depots;

    }

    @Override
    public Page<Depot> findSortedDepotByPagination(int offset, int pageSize, String field) {
        Page<Depot> depots = depotRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return depots;
    }

    @Override
    public List<Depot> findUserByName(String name) {
        List<Depot> depotsName = depotRepository.findByNameContaining(name);
        return depotsName;
    }
}
