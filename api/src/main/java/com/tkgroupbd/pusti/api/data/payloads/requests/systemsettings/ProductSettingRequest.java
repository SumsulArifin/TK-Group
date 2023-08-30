package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.models.enums.DeliveryCriteria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.sql.Date;

@Data
public class ProductSettingRequest extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private DeliveryCriteria deliveryCriteria;
    private String deliveryInDays;
    private Products products;

}
