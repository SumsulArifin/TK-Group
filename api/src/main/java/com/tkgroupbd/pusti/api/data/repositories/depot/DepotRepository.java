package com.tkgroupbd.pusti.api.data.repositories.depot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tkgroupbd.pusti.api.data.models.entity.depot.Depot;

@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {
    List<Depot> findByNameContaining(String name);
}
