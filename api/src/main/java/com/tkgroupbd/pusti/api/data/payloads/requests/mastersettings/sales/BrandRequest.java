package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BrandRequest extends BaseEntity {
    @NotBlank
    @NotNull
    private String brandName;
    @NotBlank
    @NotNull
    private String brandType;
}
