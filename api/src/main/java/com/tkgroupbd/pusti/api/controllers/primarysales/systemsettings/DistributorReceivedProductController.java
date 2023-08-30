package com.tkgroupbd.pusti.api.controllers.primarysales.systemsettings;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.DistributorReceivedProduct;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.DistributorReceivedProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.systemsettings.DistributorReceivedProductServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Distributor Received Product")
@RestController
@RequestMapping("/distributorReceivedProduct")
public class DistributorReceivedProductController {
    @Autowired
    private DistributorReceivedProductServiceImpl service;

    // create new Distributor Received Product Setting
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> createDistributorReceivedProduct(
            @RequestBody DistributorReceivedProductRequest request) {
        MessageResponse receivedProduct = service.createDistributorReceivedProduct(request);
        return new ResponseEntity<>(receivedProduct, HttpStatus.CREATED);
    }

    // retrieve all Distributor Received Product Setting
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<DistributorReceivedProduct>> getAllDistributorReceivedProduct() {
        List<DistributorReceivedProduct> receivedProducts = service.getAllDistributorReceivedProduct();
        return new ResponseEntity<>(receivedProducts, HttpStatus.OK);
    }

    // Update DistributorReceivedProduct
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<DistributorReceivedProduct>> updateDistributorReceivedProduct(
            @PathVariable Integer id,
            @RequestBody DistributorReceivedProductRequest request) {
        Optional<DistributorReceivedProduct> receivedProduct = service.updateDistributorReceivedProduct(id, request);
        return new ResponseEntity<Optional<DistributorReceivedProduct>>(receivedProduct, HttpStatus.OK);
    }

    // Status Change API
    @PutMapping("/statusChange/{id}")
    public ResponseEntity<Optional<DistributorReceivedProduct>> distributorReceivedProductStatusChange(
            @PathVariable Integer id,
            @RequestBody DistributorReceivedProductRequest request) {
        Optional<DistributorReceivedProduct> receivedProduct = service.distributorReceivedProductStatusChange(id,
                request);
        return new ResponseEntity<Optional<DistributorReceivedProduct>>(receivedProduct, HttpStatus.OK);
    }

    // Delete Distributor Received Product by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDistributorReceivedProduct(@PathVariable("id") Integer id) {
        service.deleteDistributorReceivedProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // API to retrieve Distributor Received Product by id
    @GetMapping("/getById/{id}")
    public ResponseEntity<DistributorReceivedProduct> getDistributorReceivedProductById(
            @PathVariable("id") Integer id) {
        DistributorReceivedProduct receivedProduct = service.getDistributorReceivedProductById(id);
        return new ResponseEntity<>(receivedProduct, HttpStatus.OK);
    }

    @GetMapping("/getPaginated/{offset}/{pageSize}")
    private ApiResponse<Page<DistributorReceivedProduct>> findAltChannelSettingsByPagination(@PathVariable int offset,
            @PathVariable int pageSize) {
        Page<DistributorReceivedProduct> receivedProducts = service.findDistributorReceivedProductByPagination(offset,
                pageSize);
        return new ApiResponse(receivedProducts.getSize(), receivedProducts);
    }

    @GetMapping("/getSortedPaginated/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<DistributorReceivedProduct>> findSortedAltChannelSettingsByPagination(
            @PathVariable int offset,
            @PathVariable int pageSize, @PathVariable String field) {
        Page<DistributorReceivedProduct> receivedProducts = service
                .findSortedDistributorReceivedProductByPagination(offset, pageSize, field);
        return new ApiResponse(receivedProducts.getSize(), receivedProducts);
    }

}
