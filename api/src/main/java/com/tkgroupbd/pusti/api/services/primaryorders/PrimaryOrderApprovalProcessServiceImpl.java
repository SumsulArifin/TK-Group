package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.PrimaryOrderApprovalProcess;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.PrimaryOrderApprovalProcessRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.primaryorders.PrimaryOrderApprovalProcessRepository;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimaryOrderApprovalProcessServiceImpl implements PrimaryOrderApprovalProcessService {

    @Autowired
    PrimaryOrderApprovalProcessRepository primaryOrderApprovalRepository;

    @Override
    public MessageResponse createPrimaryOrderApproval(PrimaryOrderApprovalProcessRequest request) {
        PrimaryOrderApprovalProcess primaryOrderApproval = new PrimaryOrderApprovalProcess();

        primaryOrderApproval.setApprovalCommittee(request.getApprovalCommittee());
        primaryOrderApproval.setComments(request.getComments());
        primaryOrderApproval.setApprovalStatus(request.getApprovalStatus());
        primaryOrderApproval.setNextApprove(request.getNextApprove());
        primaryOrderApproval.setOrders(request.getOrders());
        primaryOrderApproval.setCreatedAt(request.getCreatedAt());
        primaryOrderApproval.setUpdatedAt(request.getUpdatedAt());
        primaryOrderApproval.setDeletedAt(request.getDeletedAt());
        primaryOrderApprovalRepository.save(primaryOrderApproval);
        return new MessageResponse(Message.SUCCESS_CREATION);
    }
}
