package com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import lombok.Data;

@Data
public class SalesOrderProductDeliveryInfoRequest extends BaseEntity {
    private String product_sku;
    private String delivered_quantity;
    private SalesOrderDetails salesOrderDetails;
}
