package com.tkgroupbd.pusti.api.services.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovePrimaryOrders;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderOutletCoverage;
import com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder.SalesOrderOutletCoverageRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface SalesOrderOutletCoverageService {

    MessageResponse createSalesOrderOutletCoverage(SalesOrderOutletCoverageRequest salesOrderOutletCoverageRequest);
    Optional<SalesOrderOutletCoverage> updateSalesOrderOutletCoverage(int id,SalesOrderOutletCoverageRequest salesOrderOutletCoverageRequest);
    SalesOrderOutletCoverage getSalesOrderOutletCoverageById(Integer id);
    List<SalesOrderOutletCoverage>getAllSalesOrderOutletCoverage();
    public List<SalesOrderOutletCoverage> getSalesOrderOutletCoverageByOutletId(int id);

}
