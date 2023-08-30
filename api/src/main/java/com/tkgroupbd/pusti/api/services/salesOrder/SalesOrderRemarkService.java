package com.tkgroupbd.pusti.api.services.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderRemark;
import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.AlternateChannelSettings;
import com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder.SalesOrderRemarkRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.AlternateChannelSettingsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface SalesOrderRemarkService {
    MessageResponse createSalesOrderRemark(SalesOrderRemarkRequest request);
    Optional<SalesOrderRemark> updateSalesOrderRemark(Integer id, SalesOrderRemarkRequest request);
    void deleteSalesOrderRemark(Integer id);
    SalesOrderRemark getSalesOrderRemarkById(Integer id);
    List<SalesOrderRemark> getAllSalesOrderRemark();
    Optional<SalesOrderRemark> salesOrderRemarkStatusChange(Integer id, SalesOrderRemarkRequest request);
}
