package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.PrimaryOrderApprovals;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.PrimaryOrderApprovalsRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrimaryOrderApprovalsServices {

    public PrimaryOrderApprovals savePrimaryOrderApprovalsWithOther(
            PrimaryOrderApprovalsRequest primaryOrderApprovalsRequest);

    public List<PrimaryOrderApprovals> getAllPrimaryOrderApprovals();

    public PrimaryOrderApprovals getPrimaryOrderApprovalsById(long id);

}
