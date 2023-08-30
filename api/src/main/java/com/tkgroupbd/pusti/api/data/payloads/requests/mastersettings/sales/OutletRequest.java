package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import lombok.Data;
import lombok.EqualsAndHashCode;;

@Data
@EqualsAndHashCode(callSuper = false)
public class OutletRequest extends BaseEntity {
    private String name;
    private String contactPerson;
    private String mobile;
    private String address;
    private double salesPerMonth;
    private String outletKey;
    private String channelId;
    private boolean displayed;
    private double paidAmount;
    private String creditSalesId;
    private String businessType;
    private Route route;
}
