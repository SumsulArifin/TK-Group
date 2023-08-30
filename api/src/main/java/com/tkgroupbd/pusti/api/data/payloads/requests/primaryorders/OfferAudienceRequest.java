package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.Offer;
import com.tkgroupbd.pusti.api.data.models.enums.AudienceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.sql.Date;

@Data
public class OfferAudienceRequest extends BaseEntity {

    private AudienceType audienceType;
    @Enumerated(EnumType.STRING)
    private String audienceIds;
    private Offer offer;

}
