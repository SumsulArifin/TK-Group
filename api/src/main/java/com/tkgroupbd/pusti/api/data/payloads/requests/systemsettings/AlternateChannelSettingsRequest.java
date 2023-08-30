package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import lombok.Data;

import java.sql.Date;

@Data
public class AlternateChannelSettingsRequest extends BaseEntity {
    private String startDate;
    private String endDate;
    private String eligibleAreaIds;
    private String eligibleOutletIds;
    private Products products;

}
