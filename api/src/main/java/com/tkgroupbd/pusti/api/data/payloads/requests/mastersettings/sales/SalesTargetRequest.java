package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import com.tkgroupbd.pusti.api.data.models.enums.AudienceType;
import com.tkgroupbd.pusti.api.data.models.enums.TargetType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SalesTargetRequest extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private TargetType targetType;
    @Enumerated(EnumType.STRING)
    private AudienceType audienceType;
    private int audienceId;
    private String yearmonth;
    private String quantity;
    private String dp;
    private String tp;
    private String dealerId;
    private String tsoId;
    private String rsmId;
    private String asmId;
    private Region region;
    private Products products;
}
