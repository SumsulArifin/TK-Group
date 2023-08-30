package com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalesTargetRepository extends JpaRepository<SalesTarget,Integer> {

//    List<Sales_Target> findBySalesTargetName(String name);
}
