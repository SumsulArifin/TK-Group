package com.tkgroupbd.pusti.api.controllers.allReport;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrder;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("salesReport")
public class SalesReportController {

    @Autowired
    SalesOrderService salesOrderService;

    @GetMapping("/getByZoneId/{zoneId}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderByZoneId(@PathVariable("zoneId") Integer zoneId) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByZoneId(zoneId);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }
    @GetMapping("/getByDistributor/{distributor_id}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderByDistributorId(@PathVariable("distributor_id") Integer distributor_id) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByZoneId(distributor_id);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }
    @GetMapping("/getBySalesOfficer/{assignedSoId}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderBySalesOfficerId(@PathVariable("assignedSoId") Integer assignedSoId) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByZoneId(assignedSoId);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }
    @GetMapping("/getByRegion/{regionId}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderByRegionId(@PathVariable("regionId") Integer regionId) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByZoneId(regionId);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }

    @GetMapping("/getByRoute/{routeId}")
    public ResponseEntity<List<SalesOrder>> getSalesOrderByRouteId(@PathVariable("routeId") Integer routeId) {
        List<SalesOrder> salesOrders = salesOrderService.findAllSalesOrderByZoneId(routeId);
        return new ResponseEntity<>(salesOrders, HttpStatus.OK);
    }




}
