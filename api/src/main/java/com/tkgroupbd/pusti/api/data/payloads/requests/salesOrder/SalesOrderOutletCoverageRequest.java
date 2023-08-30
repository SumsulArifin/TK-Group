package com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.*;
import lombok.Data;

@Data
public class SalesOrderOutletCoverageRequest extends BaseEntity {
    private int quantity;
    private Distributor distributor;
    private AssignedSalesOfficer assignedSalesOfficer;
    private Route route;
    private Outlet outlet;
    private Brand brand;
}
