package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.Feature;
import lombok.Data;

import java.sql.Date;

@Data
public class DashboardSettingRequest extends BaseEntity {

    private Feature feature;
    private int roleId;


}
