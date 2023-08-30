package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.enums.OfferIn;
import com.tkgroupbd.pusti.api.data.models.enums.OfferedUnitId;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OfferDetailsRequest extends BaseEntity {
    private OfferIn offerIn;
    private OfferedUnitId offeredUnitId;
    private double fromQuantity = 0;
    private double toQuantity = 0;
    private String comboCriteria;
    private double offeredQuantity = 0;
    private double offeredTaka;
}
