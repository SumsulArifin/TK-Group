package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SoWorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoWorkingDayRepository extends JpaRepository<SoWorkingDay, Integer> {
    @Query(value = "select wd.*, so.* from SoWorkingDay wd inner join wd.salesOfficer so on wd.salesOfficer.assignedSoId = so.assignedSoId", nativeQuery = true)
    public List<SoWorkingDay> findAllSoWorkingDay();

    @Query(value = "select wd.* from SoWorkingDay wd where wd.salesOfficer.assignedSoId=?1", nativeQuery = true)
    public List<SoWorkingDay> findSoWorkingDayBySalesOfficerId(int id);
}
