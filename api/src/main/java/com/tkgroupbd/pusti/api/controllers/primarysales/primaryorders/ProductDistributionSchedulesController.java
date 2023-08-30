package com.tkgroupbd.pusti.api.controllers.primarysales.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ProductDistributionSchedules;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ProductDistributionSchedulesRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.primaryorders.ProductDistributionSchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productDistributionSchedules")
public class ProductDistributionSchedulesController {
    @Autowired
    ProductDistributionSchedulesService productDistributionSchedulesService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addProductDistributionSchedules(
            @RequestBody ProductDistributionSchedulesRequest request) {
        MessageResponse productDistributionSchedules = productDistributionSchedulesService.createProductDistributionSchedules(request);
        return new ResponseEntity<>(productDistributionSchedules, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductDistributionSchedules>> getOfferAudienceByOfferId() {
        List<ProductDistributionSchedules> productDistributionSchedules = productDistributionSchedulesService
                .getAllProductDistributionSchedules();
        return new ResponseEntity<>(productDistributionSchedules, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<ProductDistributionSchedules>> updateProductDistributionSchedules(
            @PathVariable Integer id,
            @RequestBody ProductDistributionSchedulesRequest request) {
        Optional<ProductDistributionSchedules> productDistributionSchedules = productDistributionSchedulesService
                .updateProductDistributionSchedules(id, request);
        return new ResponseEntity<Optional<ProductDistributionSchedules>>(productDistributionSchedules, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<?> deleteDailyOrdersSummary(@PathVariable("id") Integer id) {
        productDistributionSchedulesService.deleteProductDistributionSchedulesById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // @PutMapping("/statusChange/{id}")
    // public ResponseEntity<Optional<ProductDistributionSchedules>>
    // statusChangeProductDistributionSchedules(
    // @PathVariable Integer id, @RequestBody ProductDistributionSchedulesRequest
    // request) {
    // Optional<ProductDistributionSchedules> productDistributionSchedules =
    // productDistributionSchedulesService
    // .ProductDistributionSchedulesStatusChange(id, request);
    // return new
    // ResponseEntity<Optional<ProductDistributionSchedules>>(productDistributionSchedules,
    // HttpStatus.OK);
    // }

}
