package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class BankRequest extends BaseEntity {

    @NotBlank
    @NotNull
    private String bankName;

    @NotBlank
    @NotNull
    private boolean status;
}
