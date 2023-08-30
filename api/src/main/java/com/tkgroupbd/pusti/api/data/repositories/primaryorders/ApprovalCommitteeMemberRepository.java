package com.tkgroupbd.pusti.api.data.repositories.primaryorders;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalCommitteeMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApprovalCommitteeMemberRepository extends JpaRepository<ApprovalCommitteeMember,Integer> {
     @Query("select a.employee.employeeId from ApprovalCommitteeMember a where a.approvalCommittee.committeeId=?1")
     public List<ApprovalCommitteeMember> findApprovalCommitteeMemberByApprovalCommitteeId(int id);
}
