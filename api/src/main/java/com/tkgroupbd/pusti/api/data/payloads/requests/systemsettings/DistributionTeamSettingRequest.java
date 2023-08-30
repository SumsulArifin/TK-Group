package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class DistributionTeamSettingRequest extends BaseEntity {

    private String teamName;

}
