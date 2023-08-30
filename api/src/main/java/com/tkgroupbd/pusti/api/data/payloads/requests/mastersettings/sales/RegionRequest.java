package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Division;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegionRequest extends BaseEntity {
    @NotBlank
    @NotNull
    private String regionName;
    private Division division;
}
