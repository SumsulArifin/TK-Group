package com.tkgroupbd.pusti.api.data.models.entity.systemsettings;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "time_pass")
public class TimePass extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int timeId;

    private String numberOfDaysInMonth;
    private String numberOfHolidays;
    private String workingDaysInMonth;
    @JsonFormat(pattern = "yyyy-MM")
    private String yearMonth;
}
