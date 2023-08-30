package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.AssignedSalesOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignedSalesOfficerRepository
        extends JpaRepository<AssignedSalesOfficer, Integer>, JpaSpecificationExecutor<AssignedSalesOfficer> {

    // @Query("select aso.* from Assigned_Sales_Officer aso where
    // aso.route.routeId=?1")
    // public List<AssignedSalesOfficer> findAssignedSalesOfficerByRouteId(int
    // routeId);
}
