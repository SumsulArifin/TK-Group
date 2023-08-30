package com.tkgroupbd.pusti.api.services.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface SalesOrderDetailsService {
    public List<SalesOrderDetails> salesOrderDetails();
    public List<SalesOrderDetails> salesOrderDetailsBetween(LocalDate startDate, LocalDate endDate);
    public List<SalesOrderDetails> salesOrderDetailsAllByAssignedSalesOfficerId(int id);
    public List<Object[]> getAssignedSalesOfficerOrderedMost();
    public List<Object[]> getAssignedSalesOfficerOrderedLeast();
    public List<Object[]> findSKUByRoute_ID(int routeId);
    }
