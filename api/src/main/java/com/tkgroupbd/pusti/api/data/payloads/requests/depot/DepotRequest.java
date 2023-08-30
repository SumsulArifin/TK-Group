package com.tkgroupbd.pusti.api.data.payloads.requests.depot;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepotRequest extends BaseEntity {

    @NotBlank
    @NotNull
    private String name;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String phone;
}
