package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommittee;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommitteeMember;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovalCommitteeRequest;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ApprovalCommitteeService {
    public ApprovalCommittee saveApprovalCommitteeWithApprovalCommitteeMember(ApprovalCommitteeRequest request);

    public Optional<ApprovalCommittee> updateApprovalCommittee(int id, ApprovalCommitteeRequest request);

    public List<ApprovalCommittee> getAllApprovalCommittee();

    public ApprovalCommitteeMember getApprovalCommitteeDetailById(int id);

    public void deleteApprovalCommitteeById(int id);
}
