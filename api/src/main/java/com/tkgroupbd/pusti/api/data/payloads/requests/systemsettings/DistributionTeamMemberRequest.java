package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Employee;
import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.Team;
import lombok.Data;

import java.sql.Date;

@Data
public class DistributionTeamMemberRequest extends BaseEntity {
    private Team team;
    private Employee employee;

}
