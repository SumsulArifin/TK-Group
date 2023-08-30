package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.ZoneRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ZoneService {

    MessageResponse createZone(ZoneRequest zoneRequest);

    Optional<Zone> updateZone(Integer id, ZoneRequest zoneRequest);

    void deleteZone(Integer id);

    Zone getZoneById(Integer id);

    List<Zone> getAllZone();

    List<Zone> findZoneByRegionId(Integer id);

    List<Zone> findByZoneName(String name);

    Optional<Zone> zoneStatusChange(Integer id, ZoneRequest zoneRequest);

}
