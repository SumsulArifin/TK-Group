package com.tkgroupbd.pusti.api.data.repositories.primaryorders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.DailyOrdersSummary;

import java.util.List;

@Repository
public interface DailyOrdersSummaryRepository extends JpaRepository<DailyOrdersSummary, Integer> {
    @Query("select d from DailyOrdersSummary d where d.salesOfficer.assignedSoId=?1")
    public List<DailyOrdersSummary> findDailyOrdersSummaryBySoId(int id);
}
