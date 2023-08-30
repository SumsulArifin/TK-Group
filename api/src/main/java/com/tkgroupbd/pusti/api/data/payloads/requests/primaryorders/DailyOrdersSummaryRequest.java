package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesOfficer;
import lombok.Data;

import java.sql.Date;

@Data
public class DailyOrdersSummaryRequest extends BaseEntity {
    private String numberOfSkus;
    private String numberOfCategories;
    private double ccp;
    private double lpc;
    private SalesOfficer salesOfficer;
}
