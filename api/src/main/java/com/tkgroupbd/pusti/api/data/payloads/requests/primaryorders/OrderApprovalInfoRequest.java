package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.PurchaseOrders;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderApprovalInfoRequest extends BaseEntity {
    private String comments;
    private boolean currentStatus;
    private PurchaseOrders orders;
    private Employee employee;

}
