package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class DivisionRequest extends BaseEntity {
    @NotBlank
    @NotNull
    private String divisionName;
}
