package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.PrimaryOrderApprovalProcess;
import lombok.Data;

@Data
public class ApprovePrimaryOrdersRequest {
    private PrimaryOrderApprovalProcess primaryOrderApproval;
    private String comments;
}
