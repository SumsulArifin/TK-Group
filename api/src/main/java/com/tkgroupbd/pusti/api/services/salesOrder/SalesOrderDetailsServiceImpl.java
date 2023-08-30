package com.tkgroupbd.pusti.api.services.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.PendingProduct;
import com.tkgroupbd.pusti.api.data.repositories.salesOrder.SalesOrderDetailsRepository;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalesOrderDetailsServiceImpl implements SalesOrderDetailsService{
    @SuppressWarnings(Message.AUTOWIRED_OK)
    @Autowired
    private SalesOrderDetailsRepository salesOrderDetailsRepository;
    @Override
    public List<SalesOrderDetails> salesOrderDetails(){
        List<SalesOrderDetails> salesOrderDetails = salesOrderDetailsRepository.findByCreatedAt(LocalDate.now());
        return salesOrderDetails;
    }

    @Override
    public List<SalesOrderDetails> salesOrderDetailsBetween(LocalDate startDate, LocalDate endDate){
        List<SalesOrderDetails> salesOrderDetails = salesOrderDetailsRepository.findByCreatedAtBetween(startDate,endDate);
        return salesOrderDetails;
    }

    @Override
    public List<SalesOrderDetails> salesOrderDetailsAllByAssignedSalesOfficerId(int id){
        List<SalesOrderDetails> salesOrderDetails = salesOrderDetailsRepository.findByAssignedSalesOfficer(id);
        return salesOrderDetails;
    }

    @Override
    public List<Object[]> getAssignedSalesOfficerOrderedMost() {
        return salesOrderDetailsRepository.findAssignedSalesOfficerOrderedMost();
    }
    
    @Override
    public List<Object[]> getAssignedSalesOfficerOrderedLeast() {
        return salesOrderDetailsRepository.findAssignedSalesOfficerOrderedLeast();
    }

    public List<Object[]> findSKUByRoute_ID(int routeId) {
        return salesOrderDetailsRepository.findSKUByRouteId(routeId);
    }

}
