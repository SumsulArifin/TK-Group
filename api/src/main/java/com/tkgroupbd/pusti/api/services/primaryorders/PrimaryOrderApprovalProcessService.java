package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.PrimaryOrderApprovalProcessRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

@Component
public interface PrimaryOrderApprovalProcessService {
    MessageResponse createPrimaryOrderApproval(PrimaryOrderApprovalProcessRequest request);
}
