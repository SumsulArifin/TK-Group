package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.RegionRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.RegionService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Region")
@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    RegionService regionService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> regionSave(@RequestBody RegionRequest regionRequest) {
        MessageResponse newRegion = regionService.saveRegion(regionRequest);
        return new ResponseEntity<>(newRegion, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Region>> getRegion() {
        List<Region> region = regionService.getAllRegion();
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{regionId}")
    public ResponseEntity<?> deleteZones(@PathVariable("regionId") Integer regionId) {
        regionService.deleteRegionById(regionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{regionId}")
    public ResponseEntity<Region> getRegionById(@PathVariable("regionId") Integer regionId) {
        Region region = regionService.findRegionById(regionId);
        return new ResponseEntity<>(region, HttpStatus.OK);
    }

    @PutMapping("/update/{regionId}")
    public ResponseEntity<Optional<Region>> updateZone(@PathVariable Integer regionId,
            @RequestBody RegionRequest regionRequest) {
        Optional<Region> region = regionService.updateRegion(regionId, regionRequest);
        return new ResponseEntity<Optional<Region>>(region, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{regionId}")
    public ResponseEntity<Optional<Region>> updateZoneStatus(@PathVariable Integer regionId,
            @RequestBody RegionRequest regionRequest) {
        Optional<Region> region = regionService.updateRegionStatus(regionId, regionRequest);
        return new ResponseEntity<Optional<Region>>(region, HttpStatus.OK);
    }

    @GetMapping("/getSortedByKey/{field}")
    private ApiResponse<List<Region>> getSortedRegionByKey(@PathVariable String field) {
        List<Region> regionList = regionService.findSortedRegionByKey(field);
        return new ApiResponse(regionList.size(), regionList);
    }

}
