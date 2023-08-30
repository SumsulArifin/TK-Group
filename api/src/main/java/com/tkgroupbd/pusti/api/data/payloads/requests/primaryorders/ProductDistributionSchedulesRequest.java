package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.PurchaseOrders;
import com.tkgroupbd.pusti.api.data.models.enums.PDSStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import java.sql.Date;

@Data
public class ProductDistributionSchedulesRequest extends BaseEntity {
    private String SKU;
    private int plannedQuantity;
    private int deliveredQuantity;
    private String comment;
    @Enumerated(EnumType.STRING)
    private PDSStatus pdsStatus;
    private Date deliveryDate;
    private PurchaseOrders purchaseOrders;

}
