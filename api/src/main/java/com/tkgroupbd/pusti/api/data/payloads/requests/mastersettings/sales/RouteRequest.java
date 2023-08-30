package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class RouteRequest extends BaseEntity {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private boolean status;
    private String assignedDistributorId;
    private Zone zone;
}
