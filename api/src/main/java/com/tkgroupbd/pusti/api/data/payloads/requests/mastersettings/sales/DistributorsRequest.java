package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class DistributorsRequest extends BaseEntity {
    private int depot_id;
    private String name;
    private String erp_id;
    private String proprietor_name;
    private String proprietor_dob;
    private String mobile;
    private String address;
    private String has_pc;
    private String has_printer;
    private String has_live_app;
    private String has_direct_sale;
    private String opening_date;
    private String emergency_contact_name;
    private String emergency_contact_number;
    private String emergency_person_relation;
    private Route route;
}
