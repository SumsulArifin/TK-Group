package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegionRepository extends JpaRepository<Region ,Integer> {

    @Query("select r from Region r inner join r.division d on r.division.divisionId = d.divisionId")
    public List<Region> findAllRegen();


    @Query("select r from Region r where r.division.divisionId=?1")
    public List<Region> findRegionByDivisionId(int id);
}
