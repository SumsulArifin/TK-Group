package com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders;

import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

import com.tkgroupbd.pusti.api.data.models.common.BaseEntity;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApprovalCommitteeRequest extends BaseEntity {
    private String name;
    private List<ApprovalCommitteeMemberRequest> approvalCommitteeMemberRequests;
}
