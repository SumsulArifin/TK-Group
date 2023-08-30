package com.tkgroupbd.pusti.api.data.payloads.requests.secondaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.ProductItem;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.AssignedSalesOfficer;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.OutletAmendment;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesOfficer;
import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.PendingProduct;
import com.tkgroupbd.pusti.api.data.models.enums.DeliveryStatus;
import com.tkgroupbd.pusti.api.data.models.enums.DeliveryType;
import com.tkgroupbd.pusti.api.data.models.enums.ReceivedFrom;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import lombok.Data;


@Data
public class DeliveredProductRequest extends BaseEntity {
    private int scheduleOutlet;
    private int visitedOutlet;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private ReceivedFrom receivedFrom;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;
    private ProductItem productItem;
    private OutletAmendment outletAmendment;
    private AssignedSalesOfficer assignedSalesOfficer;
    private PendingProduct pendingProduct;

}
