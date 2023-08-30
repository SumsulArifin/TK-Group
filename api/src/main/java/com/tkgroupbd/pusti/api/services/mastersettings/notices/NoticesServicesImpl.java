package com.tkgroupbd.pusti.api.services.mastersettings.notices;

import com.tkgroupbd.pusti.api.data.models.entity.notices.Notice;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.NoticesRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.notices.NoticesRepository;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoticesServicesImpl implements NoticesServices {
    @Autowired
    NoticesRepository noticesRepository;

    @Override
    public MessageResponse addNotices(NoticesRequest noticesRequest) {
        Notice notices = new Notice();
        notices.setNoticeDetails(noticesRequest.getNoticeDetails());
        notices.setNoticeType(noticesRequest.getNoticeType());
        notices.setStatus(noticesRequest.isStatus());
        notices.setEffectiveDate(noticesRequest.getEffectiveDate());
        notices.setCreatedAt(noticesRequest.getCreatedAt());
        notices.setUpdatedAt(noticesRequest.getUpdatedAt());
        notices.setDeletedAt(noticesRequest.getDeletedAt());
        noticesRepository.save(notices);
        return new MessageResponse(Message.SUCCESS_DEPOT_CREATION);
    }

    @Override
    public Optional<Notice> updateNotices(Integer id, NoticesRequest noticesRequest) {

        return null;
    }

    @Override
    public Optional<Notice> statusChangeAPI(Integer brandId, NoticesRequest noticesRequest) {
        return Optional.empty();
    }

    @Override
    public void deleteNotices(Integer id) {
        noticesRepository.deleteById(id);

    }

    @Override
    public Notice getNoticesById(Integer id) {
        return noticesRepository.findById(id).get();
    }

    @Override
    public List<Notice> getAllNotices() {
        return noticesRepository.findAll();
    }
}
