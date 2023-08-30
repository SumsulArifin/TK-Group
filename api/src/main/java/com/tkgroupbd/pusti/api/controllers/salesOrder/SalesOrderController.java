package com.tkgroupbd.pusti.api.controllers.salesOrder;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrder;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderOutletCoverage;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder.SalesOrderOutletCoverageRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder.SalesOrderRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderService;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderServiceImpl;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/salesOrder")
public class SalesOrderController {
    @Autowired
    SalesOrderService salesOrderService;

    @PostMapping("/add")
    private ResponseEntity<MessageResponse> saveSalesOrderWithDetails(@RequestBody SalesOrderRequest salesOrderRequest){
        MessageResponse salesOrder=salesOrderService.addSalesOrder(salesOrderRequest);
        return new ResponseEntity<>(salesOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateSalesOrder(@PathVariable int id, @RequestBody SalesOrderRequest salesOrderRequest) {
        MessageResponse response = salesOrderService.updateSalesOrder(id, salesOrderRequest);
        HttpStatus status = (response.getMessage().equals(Message.SUCCESS_CREATION)) ?
                HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(response, status);
    }

    @GetMapping("/getByOutletId/{id}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderByOutletId(@PathVariable("id") Integer id) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByOutletId(id);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }
    @GetMapping("/getByRouteId/{id}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderByRouteId(@PathVariable("id") Integer id) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByRouteId(id);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }
//    @GetMapping("/getByDate/{createdAt}")
//    public ResponseEntity<List<SalesOrder>> getSalesOrderByDate(@PathVariable("createdAt") Date createdAt) {
//        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderBySelectedDate(createdAt);
//        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
//    }


}
