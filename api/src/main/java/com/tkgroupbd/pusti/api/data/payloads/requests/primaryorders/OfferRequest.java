package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class OfferRequest extends BaseEntity {
    private String name;
    private String offerType;
    private boolean status;
    private String startDate;
    private String endDate;
    private List<OfferDetailsRequest> offerDetailsRequests;
}
