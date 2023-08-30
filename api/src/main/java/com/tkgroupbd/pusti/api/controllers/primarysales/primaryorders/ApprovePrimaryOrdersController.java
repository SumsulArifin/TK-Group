package com.tkgroupbd.pusti.api.controllers.primarysales.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovePrimaryOrders;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovePrimaryOrdersRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;

import com.tkgroupbd.pusti.api.services.primaryorders.ApprovePrimaryOrdersService;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approvePrimaryOrders")
public class ApprovePrimaryOrdersController {

    @Autowired
    ApprovePrimaryOrdersService approvePrimaryOrdersService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> saveApprovePrimaryOrder(
            @RequestBody ApprovePrimaryOrdersRequest approvePrimaryOrdersRequest) {
        MessageResponse approval = approvePrimaryOrdersService.createApprovePrimaryOrders(approvePrimaryOrdersRequest);
        return new ResponseEntity<>(approval, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ApprovePrimaryOrders> getApprovePrimaryOrdersById(@PathVariable("id") Integer id) {
        ApprovePrimaryOrders approvePrimaryOrders = approvePrimaryOrdersService.getApprovePrimaryOrdersById(id);
        return new ResponseEntity<>(approvePrimaryOrders, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ApprovePrimaryOrders>> getApprovePrimaryOrders() {
        List<ApprovePrimaryOrders> approvePrimaryOrders = approvePrimaryOrdersService.getAllApprovePrimaryOrders();
        return new ResponseEntity<>(approvePrimaryOrders, HttpStatus.OK);
    }

    @GetMapping("/getByPrimaryApproveOrderId/{id}")
    public ResponseEntity<List<ApprovePrimaryOrders>> getApprovePrimaryOrdersByPrimaryApproveOrderId(
            @PathVariable("id") Integer id) {
        List<ApprovePrimaryOrders> approvePrimaryOrders = approvePrimaryOrdersService
                .getApprovePrimaryOrdersByPrimaryApproveId(id);
        return new ResponseEntity<>(approvePrimaryOrders, HttpStatus.OK);
    }
}
