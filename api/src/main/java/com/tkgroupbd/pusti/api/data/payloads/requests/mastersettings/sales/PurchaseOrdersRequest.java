package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.depot.Depot;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovePrimaryOrders;
import com.tkgroupbd.pusti.api.data.models.enums.OrderType;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.PurchaseOrderItemsRequest;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseOrdersRequest extends BaseEntity {
    private String name;
    private String superDistributorId;
    @Enumerated(EnumType.STRING)
    private OrderType orderType;
    private String isApprovalRequired;
    private String approvalStatus;
    private Depot depot;
    private Distributor distributor;
    private ApprovePrimaryOrders approvePrimaryOrders;
    private List<PurchaseOrderItemsRequest> purchaseOrderItemsRequests;
}
