package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import lombok.Data;

@Data
public class CommissionSettingsRequest {

    private int productId;

    private String commissionAmount;

    private String eligibleAreaList;

    private String allowedRetailerIdList;

    private String startDate;

    private String endDate;

}
