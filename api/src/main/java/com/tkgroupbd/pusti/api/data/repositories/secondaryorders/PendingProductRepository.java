package com.tkgroupbd.pusti.api.data.repositories.secondaryorders;


import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.PendingProduct;
import com.tkgroupbd.pusti.api.data.models.enums.DeliveryStatus;
import com.tkgroupbd.pusti.api.data.models.enums.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface PendingProductRepository extends JpaRepository<PendingProduct,Integer> {
    List<PendingProduct> findByCreatedAt(LocalDate createdAt);
    List<PendingProduct> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);
    @Query("select  r from PendingProduct r where r.createdAt=:startDate and r.sku=:sku")
    List<PendingProduct> findPendingProductByCreatedAtAndSku(@Param("startDate") LocalDate startDate,@Param("sku") String sku);

    List<PendingProduct> findByStatus(boolean status);

    @Query("select p from PendingProduct p where p.primaryOrderApprovals.primaryOrderId=?1")
    List<PendingProduct> findByPrimaryOrderApprovalProcess(int id);




}
