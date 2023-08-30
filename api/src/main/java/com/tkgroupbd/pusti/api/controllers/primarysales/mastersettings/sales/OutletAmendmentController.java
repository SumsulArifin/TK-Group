package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.OutletAmendment;
import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.DistributionTeamMember;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.OutletAmendmentRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.DistributionTeamMemberRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.OutletAmendmentRepository;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.OutletAmendmentServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Tag(name = "OutletAmendment")
@RestController
@RequestMapping("/outletAmendment")
public class OutletAmendmentController {
    @Autowired
    OutletAmendmentServiceImpl service;

    @Autowired
    OutletAmendmentRepository repository;

    @PostMapping("/add")
    public ResponseEntity<List<OutletAmendment>> employeesSave(@RequestBody List<OutletAmendmentRequest> outletAmendmentRequestList) {
       MessageResponse newOutletAmendment = service.createOutletAmendment(outletAmendmentRequestList);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/bulk-update")
    public ResponseEntity<List<OutletAmendment>> updateBulkOutletAmendments(
            @RequestBody List<OutletAmendmentRequest> outletAmendmentDTOList) {
        List<OutletAmendment> updatedOutletAmendments = service.updateBulkOutletAmendments(outletAmendmentDTOList);
        return ResponseEntity.ok(updatedOutletAmendments);
    }

    @PutMapping("/update/latitudeAndLongitude/{id}")
    public ResponseEntity<Optional<OutletAmendment>> updateOutletAmendmentLatitudeAndLongitude(@PathVariable Integer id, @RequestBody OutletAmendmentRequest request) {
        Optional<OutletAmendment> outletAmendment = service.updateOutletAmendmentLatitudeAndLongitude(id, request);
        return new ResponseEntity<Optional<OutletAmendment>>(outletAmendment, HttpStatus.OK);
    }

}
