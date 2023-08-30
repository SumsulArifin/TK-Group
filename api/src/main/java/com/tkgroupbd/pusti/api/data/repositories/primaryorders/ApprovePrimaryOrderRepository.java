package com.tkgroupbd.pusti.api.data.repositories.primaryorders;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovePrimaryOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovePrimaryOrderRepository extends JpaRepository<ApprovePrimaryOrders,Integer> {

    @Query("select a from ApprovePrimaryOrders a where a.primaryOrderApproval.primaryOrderId=?1")
    public List<ApprovePrimaryOrders> findApprovePrimaryOrdersByPrimaryOrderApprovalId(int id);
}
