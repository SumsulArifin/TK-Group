package com.tkgroupbd.pusti.api.services.salesOrder;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrder;
import com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder.SalesOrderRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public interface SalesOrderService {
    public MessageResponse addSalesOrder(SalesOrderRequest salesOrderRequest);
    public List<Object[]> getAllSalesOrder();
    public MessageResponse  updateSalesOrder(int id, SalesOrderRequest salesOrderRequest);
    public List<SalesOrder> findAllSalesOrderByRouteId(int id);
    public List<SalesOrder> findAllSalesOrderByOutletId(int id);
    public List<SalesOrder> findAllSalesOrderBySalesOfficerId(int id);
    public List<SalesOrder> findAllSalesOrderByDistributorId(int id);
    public List<SalesOrder> findAllSalesOrderByRegionId(int id);
    public List<SalesOrder> findAllSalesOrderByZoneId(int id);
    public List<Object> findAllSalesOrderBySelectedDate(int id);
    public  List<SalesOrder>sOWiseSalesReportByTheSelectedDate(int assignedSoId,LocalDate startDate, LocalDate endDate);
    public List<SalesOrder> findOderStatusByOutletId(int id, boolean orderStatus,LocalDate startDate, LocalDate endDate);
    public Integer findMaxOutletId();
    public Integer findMinOutletId();
    public List<Object[]> orderMostOutlet(LocalDate startDate, LocalDate endDate);
}
