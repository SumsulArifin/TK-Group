package com.tkgroupbd.pusti.api.data.repositories.systemsettings;

import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.TimePass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimePassRepository extends JpaRepository<TimePass,Integer> {
}
