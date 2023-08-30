package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OfferTypeRequest extends BaseEntity {
    private String name;
}
