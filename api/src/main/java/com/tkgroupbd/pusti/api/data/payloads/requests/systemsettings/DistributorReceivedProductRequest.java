package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Distributor;
import lombok.Data;

import java.sql.Date;

@Data
public class DistributorReceivedProductRequest extends BaseEntity {

    private String receivedYearMonth;
    private int receivedQuantity;
    private double distributorPrice;
    private double receivedFree;
    private double receivedAdjusted;
    private double receivedFreeAdjusted;
    private double blockedStock;
    private String operationType;
    private Products products;
    private Distributor distributor;

}
