package com.tkgroupbd.pusti.api.data.repositories.inventory;

import com.tkgroupbd.pusti.api.data.models.entity.inventory.ProductStockIn;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Zone;
import com.tkgroupbd.pusti.api.data.models.enums.ReceivedFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface ProductStockInRepository extends JpaRepository<ProductStockIn, Integer> {
    List<ProductStockIn> findAllByOrderByCreatedAtDesc();
    List<ProductStockIn> findAllByCreatedAtContaining(String createdAt);
    List<ProductStockIn> findByReceivedFrom(ReceivedFrom receivedFrom);
    @Query( "select p from ProductStockIn p where p.skuName=?1")
    public Optional<ProductStockIn> findBySkuName(String sku);
}
