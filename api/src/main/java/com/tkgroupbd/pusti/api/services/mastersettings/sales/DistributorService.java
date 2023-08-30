package com.tkgroupbd.pusti.api.services.mastersettings.sales;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.DistributorsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DistributorService {

    MessageResponse saveDistributor(DistributorsRequest distributorsRequest);
    public Optional<Distributor> updateDistributor(int distributor_id, DistributorsRequest distributorsRequest);
    public void deleteDistributorById(int distributor_id);
    public Optional<Distributor> updateDistributorStatus(int distributor_id, DistributorsRequest distributorsRequest);
    List<Distributor> findSortedDistributorByKey(String field);
    public List<Distributor> getAllDistributor();
    public  Distributor findDistributorById(int distributor_id);
}
