package com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import lombok.Data;

import java.sql.Date;

@Data
public class TimePassRequest extends BaseEntity {

    private String numberOfDaysInMonth;
    private String numberOfHolidays;
    private String workingDaysInMonth;
    private String yearMonth;


}
