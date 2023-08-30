package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesOfficer;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = false)
public class OutletAmendmentRequest extends BaseEntity {
    private int id;
    private String englishName;
    private String banglaName;
    private String englishAddress;
    private String banglaAddress;
    private String contactPerson;
    private String mobile;
    private String businessType;
    private int salesPerMonth;
    private String outletKey;
    private String shopSign;
    private int creditSales;
    private String comments;
    private double shopSignAmount;
    private double latitude;
    private double longitude;
    private int channelId;
    private String salesGroup;
    private int marketSize;
    private Route route;
    private SalesOfficer salesOfficer;

}
