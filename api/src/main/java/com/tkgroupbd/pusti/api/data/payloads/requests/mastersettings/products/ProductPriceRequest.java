package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductPriceRequest extends BaseEntity {
    private int proPriceId;
    private String sku;
    private double tradePrice;
    private double distributionPrice;
}
