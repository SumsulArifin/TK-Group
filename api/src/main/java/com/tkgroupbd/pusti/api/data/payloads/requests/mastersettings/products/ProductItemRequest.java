package com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import com.tkgroupbd.pusti.api.data.models.enums.UnitId;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductItemRequest extends BaseEntity {
    private int proDetailsId;
    private String sku;
    @Enumerated(EnumType.STRING)
    private UnitId sellableUnitId;
    private String erpId;
    private String weight;
    private double piecePerSale = 1;
    private int piecePerCartoon;
    private String openingDate;
    private String imageName;
    private ProductPriceRequest productPriceRequest;

}
