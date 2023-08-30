package com.tkgroupbd.pusti.api.data.payloads.requests.depot;

import com.tkgroupbd.pusti.api.data.models.entity.depot.Depot;
import com.tkgroupbd.pusti.api.data.models.entity.factory.Factory;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Category;
import lombok.Data;

@Data
public class ReceivingEntryRequest {

    private int quantity;
    private String inCharge;
    private String receivingTime;
    private Factory factory;
    private Category category;
    private Depot depot;
}
