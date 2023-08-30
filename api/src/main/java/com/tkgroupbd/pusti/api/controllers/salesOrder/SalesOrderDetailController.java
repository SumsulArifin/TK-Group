package com.tkgroupbd.pusti.api.controllers.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderDetailsServiceImpl;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/salesOrderDetails")
public class SalesOrderDetailController {
    @Autowired
    @SuppressWarnings(Message.AUTOWIRED_OK)
    private SalesOrderDetailsServiceImpl salesOrderDetailsService;

    /**
     * http://localhost:8080/salesOrderDetails/all/date
     * today date wise all product will show here
     * @return
     */
    @GetMapping("/by-date")
    public ResponseEntity<List<SalesOrderDetails>> getSalesOrderDetails() {
        List<SalesOrderDetails> salesOrdersOrderDetails = salesOrderDetailsService.salesOrderDetails();
        return new ResponseEntity<>(salesOrdersOrderDetails, HttpStatus.OK);
    }

    /**
     * http://localhost:8080/salesOrderDetails/by_date/between?startDate=2023-07-16&endDate=2023-08-16
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/by-date/between")
    public ResponseEntity<List<SalesOrderDetails>> getSalesOrderDetailsBetween(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        List<SalesOrderDetails> salesOrdersOrderDetails = salesOrderDetailsService.salesOrderDetailsBetween(startDate,endDate);
        return new ResponseEntity<>(salesOrdersOrderDetails, HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<List<SalesOrderDetails>> salesOrderDetailsAll(@PathVariable("id") int id) {
        List<SalesOrderDetails> salesOrderDetails = salesOrderDetailsService.salesOrderDetailsAllByAssignedSalesOfficerId(id);
        System.out.println(salesOrderDetails);
        return new ResponseEntity<>(salesOrderDetails, HttpStatus.OK);
    }
    @GetMapping("/most-ordered")
    public List<Object[]> getAssignedSalesOfficerOrderedMost() {
        return salesOrderDetailsService.getAssignedSalesOfficerOrderedMost();
    }
    @GetMapping("/least-ordered")
    public List<Object[]> getAssignedSalesOfficerOrderedLeast() {
        return salesOrderDetailsService.getAssignedSalesOfficerOrderedLeast();
    }
}
