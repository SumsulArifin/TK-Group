package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    @Query(value = "select zn.*, rn.* from Zone zn inner join zn.region rn on zn.region.regionId = rn.regionId", nativeQuery = true)
    public List<Zone> findAllZone();

    @Query(value = "select zn.* from Zone zn where zn.region.regionId=?1", nativeQuery = true)
    public List<Zone> findZoneByRegionId(int id);

    List<Zone> findByZoneNameContaining(String name);
}
