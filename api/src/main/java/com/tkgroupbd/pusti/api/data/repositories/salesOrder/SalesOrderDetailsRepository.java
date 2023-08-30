package com.tkgroupbd.pusti.api.data.repositories.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderDetails;
import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.PendingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesOrderDetailsRepository  extends JpaRepository<SalesOrderDetails,Integer> {
    List<SalesOrderDetails> findByCreatedAt(LocalDate date);
    List<SalesOrderDetails> findByCreatedAtBetween(LocalDate startDate, LocalDate endDate);

    @Query("select s from SalesOrderDetails s where s.salesOrder.assignedSalesOfficer.assignedId=?1 ")
    List<SalesOrderDetails> findByAssignedSalesOfficer(int id);


    /**
     * maximum sales officer which quantity is most
     * @return
     */
    @Query("SELECT sod.salesOrder.assignedSalesOfficer, SUM(sod.ordered_quantity) AS totalOrderedQuantity " +
            "FROM SalesOrderDetails sod " +
            "GROUP BY sod.salesOrder.assignedSalesOfficer " +
            "ORDER BY totalOrderedQuantity DESC")
    List<Object[]> findAssignedSalesOfficerOrderedMost();

    @Query("SELECT sod.salesOrder.assignedSalesOfficer, SUM(sod.ordered_quantity) AS totalOrderedQuantity " +
            "FROM SalesOrderDetails sod " +
            "GROUP BY sod.salesOrder.assignedSalesOfficer " +
            "ORDER BY totalOrderedQuantity ASC")
    List<Object[]> findAssignedSalesOfficerOrderedLeast();


    @Query("select  sod.sku from SalesOrderDetails sod where sod.salesOrder.route.routeId=?1")
    List<Object[]> findSKUByRouteId(int id);


}
