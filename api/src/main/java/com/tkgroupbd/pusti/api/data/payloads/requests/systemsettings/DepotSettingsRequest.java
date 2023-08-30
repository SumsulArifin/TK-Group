package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import lombok.Data;

@Data
public class DepotSettingsRequest {

    private int depotId;

    private String productIdList;

    private String maximumAlLowedProducts;

    private String allOweDdBsDbIdList;
}
