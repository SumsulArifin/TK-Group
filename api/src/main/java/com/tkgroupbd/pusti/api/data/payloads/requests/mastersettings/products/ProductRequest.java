package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest extends BaseEntity {
    private int productId;
    private String name;
    private String bengaliName;
    private boolean status;
    private Category category;

    private List<ProductItemRequest> productDetailRequests;

    private List<ProductPriceRequest> productPriceRequests;

    private List<ProductMetaRequest> productMetaRequests;

}
