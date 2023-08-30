package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, Integer> {
    // @Query("select o from Outlet o inner join o.route r on o.route.routeId =
    // r.routeId")
    // public List<Outlet> findAllOutlet();

    // @Query("select o from Outlet o where o.route.routeId=?1")
    // public List<Outlet> findOutletByZoneId(int id);

    List<Outlet> findByNameContaining(String name);
}
