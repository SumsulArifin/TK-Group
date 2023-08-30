package com.tkgroupbd.pusti.api.data.repositories.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.PrimaryOrderApprovalProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryOrderApprovalProcessRepository extends JpaRepository<PrimaryOrderApprovalProcess, Integer> {
}
