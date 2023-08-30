package com.tkgroupbd.pusti.api.services.systemsettings;



import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.TimePass;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.TimePassRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;

import java.util.List;
import java.util.Optional;

public interface TimePassService {

    MessageResponse createTimePass(TimePassRequest request);

    Optional<TimePass> updateTimePass(Integer id, TimePassRequest request);

    void deleteTimePass(Integer id);

    TimePass getTimePassById(Integer id);

    List<TimePass> getAllTimePass();

    Optional<TimePass> timePassStatusChange(Integer id, TimePassRequest request);


}
