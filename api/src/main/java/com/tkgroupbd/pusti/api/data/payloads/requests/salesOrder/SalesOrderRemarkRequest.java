package com.tkgroupbd.pusti.api.data.payloads.requests.salesOrder;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;
import lombok.Data;

@Data
public class SalesOrderRemarkRequest extends BaseEntity {
    private String remark;
}
