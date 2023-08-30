package com.tkgroupbd.pusti.api.controllers.allReport;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrder;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import com.tkgroupbd.pusti.api.services.salesOrder.SalesOrderDetailsService;
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
@RequestMapping("/routeWiseSKUSalesRepost")
public class RouteWiseSKUSalesRepost {

    @Autowired
    SalesOrderDetailsService salesOrderDetailsService;

    @GetMapping("/getBySKU/{routeId}")
    public ResponseEntity<List<Object[]>> getSKUByRouteId(@PathVariable("routeId") Integer routeId) {
        List<Object[]> salesOrderDetails = salesOrderDetailsService.findSKUByRoute_ID(routeId);
        return new ResponseEntity<>(salesOrderDetails, HttpStatus.OK);
    }


}
