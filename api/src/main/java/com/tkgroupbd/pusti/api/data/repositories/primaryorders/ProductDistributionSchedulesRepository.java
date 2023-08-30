package com.tkgroupbd.pusti.api.data.repositories.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ProductDistributionSchedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDistributionSchedulesRepository extends JpaRepository<ProductDistributionSchedules,Integer> {
}
