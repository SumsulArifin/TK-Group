package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.DistributorsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.DistributorService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Distributor")
@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    DistributorService distributorService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> distributorSave(@RequestBody DistributorsRequest distributorsRequest) {
        MessageResponse newDistributor = distributorService.saveDistributor(distributorsRequest);
        return new ResponseEntity<>(newDistributor, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Distributor>> getDistributor() {
        List<Distributor> distributors = distributorService.getAllDistributor();
        return new ResponseEntity<>(distributors, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{distributor_id}")
    public ResponseEntity<?> deleteDistributorById(@PathVariable("distributor_id") Integer distributor_id) {
        distributorService.deleteDistributorById(distributor_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{distributor_id}")
    public ResponseEntity<Distributor> getDistributorById(@PathVariable("distributor_id") Integer distributor_id) {
        Distributor distributor = distributorService.findDistributorById(distributor_id);
        return new ResponseEntity<>(distributor, HttpStatus.OK);
    }

    @PutMapping("/update/{distributor_id}")
    public ResponseEntity<Optional<Distributor>> updateDistributor(@PathVariable Integer distributor_id,
            @RequestBody DistributorsRequest distributorsRequest) {
        Optional<Distributor> distributor = distributorService.updateDistributor(distributor_id, distributorsRequest);
        return new ResponseEntity<Optional<Distributor>>(distributor, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{distributor_id}")
    public ResponseEntity<Optional<Distributor>> updateDistributorStatus(@PathVariable Integer distributor_id,
            @RequestBody DistributorsRequest distributorsRequest) {
        Optional<Distributor> distributor = distributorService.updateDistributorStatus(distributor_id,
                distributorsRequest);
        return new ResponseEntity<Optional<Distributor>>(distributor, HttpStatus.OK);
    }

    @GetMapping("/getSortedByKey/{field}")
    private ApiResponse<List<Distributor>> getSortedDistributorByKey(@PathVariable String field) {
        List<Distributor> distributors = distributorService.findSortedDistributorByKey(field);
        return new ApiResponse(distributors.size(), distributors);
    }
}
