package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssignedSalesOfficerRequest extends BaseEntity {
    private int soId;
    private Route route;
}
