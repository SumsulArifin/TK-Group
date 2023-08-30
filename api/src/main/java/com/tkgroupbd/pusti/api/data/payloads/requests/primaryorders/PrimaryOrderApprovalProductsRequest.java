package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.PrimaryOrderApprovals;
import com.tkgroupbd.pusti.api.data.models.enums.UnitId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PrimaryOrderApprovalProductsRequest extends BaseEntity {
    private long productId;
    @Enumerated(EnumType.STRING)
    private UnitId unitId;
    private int quantity;
    private long pricePerUnit;
    private long superDistributorId;

    private Products products;
    private PrimaryOrderApprovals primaryOrderApprovals;
}
