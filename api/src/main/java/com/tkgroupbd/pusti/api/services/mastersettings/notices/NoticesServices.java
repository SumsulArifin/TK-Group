package com.tkgroupbd.pusti.api.services.mastersettings.notices;

import com.tkgroupbd.pusti.api.data.models.entity.notices.Notice;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.NoticesRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface NoticesServices {

    MessageResponse addNotices(NoticesRequest noticesRequest);

    Optional<Notice> updateNotices(Integer id, NoticesRequest noticesRequest);

    Optional<Notice> statusChangeAPI(Integer brandId, NoticesRequest noticesRequest);

    void deleteNotices(Integer id);

    Notice getNoticesById(Integer id);

    List<Notice> getAllNotices();

}
