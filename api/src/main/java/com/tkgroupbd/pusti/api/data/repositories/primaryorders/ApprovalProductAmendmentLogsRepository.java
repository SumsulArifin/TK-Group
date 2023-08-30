package com.tkgroupbd.pusti.api.data.repositories.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovalProductAmendmentLogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalProductAmendmentLogsRepository extends JpaRepository<ApprovalProductAmendmentLogs,Long> {
}
