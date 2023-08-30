package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.ZoneRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.ZoneRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZoneServiceImpl implements ZoneService {

    @Autowired
    ZoneRepository zoneRepository;

    @Override
    public MessageResponse createZone(ZoneRequest zoneRequest) {
        Zone newZone = new Zone();

        newZone.setZoneName(zoneRequest.getZoneName());
        newZone.setStatus(zoneRequest.isStatus());
        newZone.setCreatedAt(zoneRequest.getCreatedAt());
        newZone.setDeletedAt(zoneRequest.getDeletedAt());
        newZone.setUpdatedAt(zoneRequest.getUpdatedAt());
        newZone.setBrowser(zoneRequest.getBrowser());
        newZone.setIp(zoneRequest.getIp());
        newZone.setRegion(zoneRequest.getRegion());

        zoneRepository.save(newZone);

        return new MessageResponse(Message.SUCCESS_ZONE_CREATION);
    }

    @Override
    public Optional<Zone> updateZone(Integer id, ZoneRequest zoneRequest) {
        Optional<Zone> result = zoneRepository.findById(id);

        if (result.isPresent()) {
            Zone zone = result.get();
            zone.setZoneName(zoneRequest.getZoneName());
            zone.setStatus(zoneRequest.isStatus());
            zone.setCreatedAt(zoneRequest.getCreatedAt());
            zone.setDeletedAt(zoneRequest.getDeletedAt());
            zone.setUpdatedAt(zoneRequest.getUpdatedAt());
            zone.setBrowser(zoneRequest.getBrowser());
            zone.setIp(zoneRequest.getIp());
            zone.setRegion(zoneRequest.getRegion());
            zoneRepository.save(zone);
        } else {
            throw new ResourceNotFoundException("Zone", "id", id);
        }

        return result;
    }

    @Override
    public void deleteZone(Integer id) {
        zoneRepository.deleteById(id);
    }

    @Override
    public Zone getZoneById(Integer id) {
        return zoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Zone", "id", id));
    }

    @Override
    public List<Zone> getAllZone() {
        return zoneRepository.findAll();
    }

    @Override
    public List<Zone> findZoneByRegionId(Integer id) {
        return zoneRepository.findZoneByRegionId(id);
    }

    @Override
    public List<Zone> findByZoneName(String name) {
        List<Zone> zones = zoneRepository.findByZoneNameContaining(name);
        return zones;
    }

    @Override
    public Optional<Zone> zoneStatusChange(Integer id, ZoneRequest zoneRequest) {
        Optional<Zone> zone = zoneRepository.findById(id);
        if (zone.isEmpty()) {
            throw new ResourceNotFoundException("Zone", "id", id);
        } else

            zone.get().setStatus(zoneRequest.isStatus());
        zoneRepository.save(zone.get());

        return zone;
    }

}
