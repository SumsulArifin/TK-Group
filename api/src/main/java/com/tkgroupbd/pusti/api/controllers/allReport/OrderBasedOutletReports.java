package com.tkgroupbd.pusti.api.controllers.allReport;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrder;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/orderBasedOutletReport")
public class OrderBasedOutletReports {
    @Autowired
    SalesOrderService salesOrderService;

//    @GetMapping("/{outletId}/orderStatus")
//    public ResponseEntity<List<SalesOrder>> findOutletByOrderStatus(@PathVariable("outletId") int outletId, @RequestParam boolean orderStatus) {
//        List<SalesOrder> salesOrders = salesOrderService.findOderStatusByOutletId(outletId, orderStatus);
//        return ResponseEntity.ok(salesOrders);
//    }


    /**
     * http://localhost:8080/orderBasedOutletReport/5/orderStatus?orderStatus=true&startDate=2023-08-27&endDate=2023-08-27
     * @param outletId
     * @param orderStatus
     * @param startDate
     * @param endDate
     * @return
     */

    @GetMapping("/{outletId}/orderStatus")
    public ResponseEntity<List<SalesOrder>> findSalesReportByOutletId(
            @PathVariable("outletId") int outletId,
            @RequestParam boolean orderStatus,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<SalesOrder> salesOrders = salesOrderService.findOderStatusByOutletId(outletId, orderStatus, startDate, endDate);
        return ResponseEntity.ok(salesOrders);
    }

    @GetMapping("/maxOutletId")
    public Integer findMaxOutletId() {
        int salesOrders = salesOrderService.findMaxOutletId();
        return salesOrders;
    }

    @GetMapping("/minOutletId")
    public Integer findMinOutletId() {
        int salesOrders = salesOrderService.findMinOutletId();
        return salesOrders;
    }

    @GetMapping("/maxDesc/date")
    public List<Object[]> orderMostOutlet(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<Object[]> outlet = salesOrderService.orderMostOutlet(startDate, endDate);
        return outlet;
    }


}
