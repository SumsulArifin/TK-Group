package com.tkgroupbd.pusti.api.data.repositories.secondaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.DeliveredProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DeliveredProductRepository extends JpaRepository<DeliveredProduct, Integer> {

    @Query("select  d from DeliveredProduct d  where d.createdAt=?1")
    List<DeliveredProduct> findByCreatedAt(LocalDate createdAt);
    @Query("SELECT d FROM DeliveredProduct d WHERE d.createdAt BETWEEN :startDate AND :endDate")
    List<DeliveredProduct> findByCreatedAtBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
