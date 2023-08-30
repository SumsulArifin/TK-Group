package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductMetaRequest extends BaseEntity {
    private int proMetaId;
    private String key;
    private String content;
    private String imageUrl;
}
