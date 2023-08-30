package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class CategoryRequest extends BaseEntity {
    private String name;
    private String effectiveDate;
}
