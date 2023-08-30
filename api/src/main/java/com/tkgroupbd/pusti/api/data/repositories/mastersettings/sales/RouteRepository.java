package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Region;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route,Integer> {

    @Query("select r from Route r inner join r.zone z on r.zone.zoneId = z.zoneId")
    public List<Region> findAllRegen();


    @Query("select r from Route r where r.zone.zoneId=?1")
    public List<Region> findRegionByDivisionId(int id);
}
