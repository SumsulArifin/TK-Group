package com.tkgroupbd.pusti.api.data.repositories.inventory;

import com.tkgroupbd.pusti.api.data.models.entity.inventory.IssuePanelActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssuePanelActivitiesRepository extends JpaRepository<IssuePanelActivities,Integer> {
}
