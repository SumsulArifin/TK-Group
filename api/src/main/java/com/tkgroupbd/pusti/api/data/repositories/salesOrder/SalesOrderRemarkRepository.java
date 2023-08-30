package com.tkgroupbd.pusti.api.data.repositories.salesOrder;

import com.tkgroupbd.pusti.api.data.models.entity.salesOrder.SalesOrderRemark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRemarkRepository extends JpaRepository<SalesOrderRemark,Integer> {
}
