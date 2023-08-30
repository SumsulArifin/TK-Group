package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommittee;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommitteeMember;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovalCommitteeMemberRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovalCommitteeRequest;
import com.tkgroupbd.pusti.api.data.repositories.primaryorders.ApprovalCommitteeMemberRepository;
import com.tkgroupbd.pusti.api.data.repositories.primaryorders.ApprovalCommitteeRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalCommitteeServiceImpl implements ApprovalCommitteeService {
    @Autowired
    private ApprovalCommitteeRepository approvalCommitteeRepository;
    @Autowired
    private ApprovalCommitteeMemberRepository approvalCommitteeMemberRepository;

    @Override
    public ApprovalCommittee saveApprovalCommitteeWithApprovalCommitteeMember(
            ApprovalCommitteeRequest approvalCommitteeRequest) {
        // Convert DiscountDTO to ApprovalCommittee entity
        ApprovalCommittee approvalCommittee = new ApprovalCommittee();
        approvalCommittee.setName(approvalCommitteeRequest.getName());
        approvalCommittee.setStatus(approvalCommitteeRequest.isStatus());
        approvalCommittee.setCreatedBy(approvalCommitteeRequest.getCreatedBy());
        approvalCommittee.setUpdatedBy(approvalCommitteeRequest.getUpdatedBy());
        approvalCommittee.setCreatedAt(approvalCommitteeRequest.getCreatedAt());
        approvalCommittee.setUpdatedAt(approvalCommitteeRequest.getUpdatedAt());
        approvalCommittee.setDeletedAt(approvalCommitteeRequest.getDeletedAt());

        // Save the ApprovalCommittee entity
        approvalCommittee = approvalCommitteeRepository.save(approvalCommittee);

        // Loop through each DiscountDetailDTO and convert to DiscountDetail entity
        for (ApprovalCommitteeMemberRequest approvalCommitteeMemberRequest : approvalCommitteeRequest
                .getApprovalCommitteeMemberRequests()) {
            ApprovalCommitteeMember approvalCommitteeMember = new ApprovalCommitteeMember();
            approvalCommitteeMember.setApprovalCommittee(approvalCommittee);
            approvalCommitteeMember.setSequenceNumber(approvalCommitteeMemberRequest.getSequenceNumber());
            approvalCommitteeMember.setCreatedBy(approvalCommitteeMemberRequest.getCreatedBy());
            approvalCommitteeMember.setEmployee(approvalCommitteeMemberRequest.getEmployee());
            approvalCommitteeMember.setUpdatedBy(approvalCommitteeMemberRequest.getUpdatedBy());
            approvalCommitteeMember.setCreatedAt(approvalCommitteeMemberRequest.getCreatedAt());
            approvalCommitteeMember.setUpdatedAt(approvalCommitteeMemberRequest.getUpdatedAt());
            approvalCommitteeMember.setDeletedAt(approvalCommitteeMemberRequest.getDeletedAt());

            // Save the DiscountDetail entity
            approvalCommitteeMemberRepository.save(approvalCommitteeMember);
        }

        return approvalCommittee;
    }

    @Override
    public Optional<ApprovalCommittee> updateApprovalCommittee(int id, ApprovalCommitteeRequest request) {
        Optional<ApprovalCommittee> result = approvalCommitteeRepository.findById(id);

        if (result.isPresent()) {
            ApprovalCommittee approvalCommittee = result.get();

            approvalCommittee.setName(request.getName());
            approvalCommittee.setStatus(request.isStatus());
            approvalCommittee.setCreatedBy(request.getCreatedBy());
            approvalCommittee.setUpdatedBy(request.getUpdatedBy());
            approvalCommittee.setCreatedAt(request.getCreatedAt());
            approvalCommittee.setUpdatedAt(request.getUpdatedAt());
            approvalCommittee.setDeletedAt(request.getDeletedAt());

            approvalCommitteeRepository.save(approvalCommittee);

        } else {
            throw new ResourceNotFoundException("ApprovalCommittee", "id", id);
        }

        return result;
    }

    @Override
    public List<ApprovalCommittee> getAllApprovalCommittee() {
        return approvalCommitteeRepository.findAll();
    }

    @Override
    public ApprovalCommitteeMember getApprovalCommitteeDetailById(int committeeId) {
        return approvalCommitteeMemberRepository.findById(committeeId)
                .orElseThrow(() -> new ResourceNotFoundException("ApprovalCommittee ", "committeeId", committeeId));
    }

    @Override
    public void deleteApprovalCommitteeById(int committeeId) {
        ApprovalCommittee approvalCommittee = approvalCommitteeRepository.findById(committeeId)
                .orElseThrow(() -> new ResourceNotFoundException("ApprovalCommittee  ", "committeeId", committeeId));

        // Delete associated ApprovalCommitteeMember before deleting the
        // ApprovalCommittee
        List<ApprovalCommitteeMember> approvalCommitteeMembers = approvalCommitteeMemberRepository
                .findApprovalCommitteeMemberByApprovalCommitteeId(committeeId);
        approvalCommitteeMemberRepository.deleteAll(approvalCommitteeMembers);

        approvalCommitteeRepository.delete(approvalCommittee);

    }
}
