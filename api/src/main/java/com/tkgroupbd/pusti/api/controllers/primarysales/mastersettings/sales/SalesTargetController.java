package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesTarget;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.SalesTargetRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.SalesTargetServices;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Sales Target")
@RestController
@RequestMapping("/salesTarget")
public class SalesTargetController {
    @Autowired
    SalesTargetServices salesTargetServices;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> salesTargetSave(@RequestBody SalesTargetRequest sales_targetRequest) {
        MessageResponse newSales_Target = salesTargetServices.addSalesTarget(sales_targetRequest);
        return new ResponseEntity<>(newSales_Target, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SalesTarget>> getSalesTarget() {
        List<SalesTarget> salesTargets = salesTargetServices.getAllSalesTarget();
        return new ResponseEntity<>(salesTargets, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteSalesTarget(@PathVariable("id") Integer id) {
        salesTargetServices.deleteSalesTarget(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<SalesTarget> getSalesTargetById(@PathVariable("id") Integer id) {
        SalesTarget salesTarget = salesTargetServices.getSalesTargetById(id);
        return new ResponseEntity<>(salesTarget, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<SalesTarget>> updateSalesTarget(@PathVariable Integer id,
            @RequestBody SalesTargetRequest sales_targetRequest) {
        Optional<SalesTarget> salesTarget = salesTargetServices.statusChangeAPI(id, sales_targetRequest);
        return new ResponseEntity<Optional<SalesTarget>>(salesTarget, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{id}")
    public ResponseEntity<Optional<SalesTarget>> updateSalesTargetStatus(@PathVariable Integer id,
            @RequestBody SalesTargetRequest sales_targetRequest) {
        Optional<SalesTarget> salesTarget = salesTargetServices.statusChangeAPI(id, sales_targetRequest);
        return new ResponseEntity<Optional<SalesTarget>>(salesTarget, HttpStatus.OK);

    }

    @GetMapping("/getSortedByKey/{field}")
    private ApiResponse<List<SalesTarget>> getSales_TargetSortedByKey(@PathVariable String field) {
        List<SalesTarget> salesTargets = salesTargetServices.findSortedSalesTargetByKey(field);
        return new ApiResponse(salesTargets.size(), salesTargets);
    }

    @GetMapping("/getPaginated/{offset}/{pageSize}")
    private ApiResponse<Page<SalesTarget>> getPaginatedSalesTarget(@PathVariable int offset,
            @PathVariable int pageSize) {
        Page<SalesTarget> salesTargets = salesTargetServices.findSalesTargetByPagination(offset, pageSize);
        return new ApiResponse(salesTargets.getSize(), salesTargets);
    }

    @GetMapping("/getSortedPaginated/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<SalesTarget>> getPaginatedSalesTarget(@PathVariable int offset,
            @PathVariable int pageSize, @PathVariable String field) {
        Page<SalesTarget> salesTargets = salesTargetServices.findSortedSalesTargetByPagination(offset, pageSize,
                field);
        return new ApiResponse(salesTargets.getSize(), salesTargets);
    }
}
