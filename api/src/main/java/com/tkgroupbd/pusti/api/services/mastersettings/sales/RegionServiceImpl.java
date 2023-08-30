package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.RegionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.RegionRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionRepository regionRepository;

    @Override
    public MessageResponse saveRegion(RegionRequest regionRequest) {
        Region newRegion = new Region();
        newRegion.setRegionName(regionRequest.getRegionName());
        newRegion.setStatus(regionRequest.isStatus());
        newRegion.setCreatedAt(regionRequest.getCreatedAt());
        newRegion.setUpdatedAt(regionRequest.getUpdatedAt());
        newRegion.setDeletedAt(regionRequest.getDeletedAt());
        newRegion.setBrowser(regionRequest.getBrowser());
        newRegion.setIp(regionRequest.getIp());
        newRegion.setDivision(regionRequest.getDivision());

        regionRepository.save(newRegion);
        return new MessageResponse(Message.SUCCESS_CREATION);
    }

    @Override
    public Optional<Region> updateRegion(int regionId, RegionRequest regionRequest) {
        Optional<Region> result = regionRepository.findById(regionId);

        if (result.isPresent()) {
            Region region = result.get();

            region.setRegionName(regionRequest.getRegionName());
            region.setStatus(regionRequest.isStatus());
            region.setCreatedAt(regionRequest.getCreatedAt());
            region.setUpdatedAt(regionRequest.getUpdatedAt());
            region.setDeletedAt(regionRequest.getDeletedAt());
            region.setBrowser(regionRequest.getBrowser());
            region.setIp(regionRequest.getIp());
            region.setDivision(regionRequest.getDivision());

            regionRepository.save(region);
        } else {
            throw new ResourceNotFoundException("Region", "regionId", regionId);
        }

        return result;
    }

    @Override
    public void deleteRegionById(int regionId) {
        regionRepository.deleteById(regionId);
    }

    @Override
    public Optional<Region> updateRegionStatus(int regionId, RegionRequest regionRequest) {
        Optional<Region> region = regionRepository.findById(regionId);
        if (region.isEmpty()) {
            throw new ResourceNotFoundException("Region", "regionId", regionId);
        } else
            region.get().setStatus(regionRequest.isStatus());
        ;
        regionRepository.save(region.get());
        return region;
    }

    @Override
    public List<Region> findSortedRegionByKey(String field) {
        return regionRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    @Override
    public List<Region> getAllRegion() {
        return regionRepository.findAll();
    }

    @Override
    public Region findRegionById(int regionId) {
        return regionRepository.findById(regionId).get();
    }
}
