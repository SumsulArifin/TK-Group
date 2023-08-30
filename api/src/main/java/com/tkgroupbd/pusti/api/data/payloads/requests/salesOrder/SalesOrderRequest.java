package com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.*;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import com.tkgroupbd.pusti.api.data.models.enums.DeliveryStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.List;

@Data
public class SalesOrderRequest extends BaseEntity {
    private String salesOrganizationId;
    private Distributor distributor;
    private AssignedSalesOfficer assignedSalesOfficer;
    private Route route;
    private Outlet outlet;
    private boolean orderStatus;
    private Zone zone;
    private Region region;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private List<SalesOrderDetailsRequest> salesOrderDetailsRequests;
}
