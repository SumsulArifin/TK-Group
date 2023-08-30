package com.tkgroupbd.pusti.api.controllers.allReport;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrder;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sOWisesSalesReport")
public class SOWisesSalesReport {

    @Autowired
    SalesOrderService salesOrderService;


    @GetMapping("/{assignedSoId}/by_date")
    public ResponseEntity<List<SalesOrder>> findSOWiseSalesReportByTheSelectedDate(
            @RequestParam int assignedSoId,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,  @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<SalesOrder> salesOrders = salesOrderService.sOWiseSalesReportByTheSelectedDate(assignedSoId,startDate,endDate);
        return ResponseEntity.ok(salesOrders);
    }



}
