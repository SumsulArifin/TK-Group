package com.tkgroupbd.pusti.api.services.mastersettings.sales;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.RegionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface RegionService {

    MessageResponse saveRegion(RegionRequest regionRequest);
    public Optional<Region> updateRegion(int regionId, RegionRequest regionRequest);
    public void deleteRegionById(int regionId);
    public Optional<Region> updateRegionStatus(int regionId, RegionRequest regionRequest);
    List<Region> findSortedRegionByKey(String field);
    public List<Region> getAllRegion();
    public  Region findRegionById(int regionId);

}
