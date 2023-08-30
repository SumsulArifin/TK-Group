package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DiscountDetailsRequest extends BaseEntity {
    private double fromQuantity;
    private double toQuantity;
    private String comboCriteria;
    private double offeredTaka;
}
