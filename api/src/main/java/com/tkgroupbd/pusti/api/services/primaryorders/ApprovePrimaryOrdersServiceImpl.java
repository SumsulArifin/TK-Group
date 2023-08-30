package com.tkgroupbd.pusti.api.services.primaryorders;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.ApprovePrimaryOrders;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.ApprovePrimaryOrdersRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.primaryorders.ApprovePrimaryOrderRepository;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ApprovePrimaryOrdersServiceImpl implements ApprovePrimaryOrdersService {

    @Autowired
    ApprovePrimaryOrderRepository approvePrimaryOrderRepository;

    @Override
    public MessageResponse createApprovePrimaryOrders(ApprovePrimaryOrdersRequest request) {
        ApprovePrimaryOrders approvePrimaryOrders=new ApprovePrimaryOrders();
        approvePrimaryOrders.setPrimaryOrderApproval(request.getPrimaryOrderApproval());
        approvePrimaryOrders.setComments(request.getComments());
        approvePrimaryOrderRepository.save(approvePrimaryOrders);

        return new MessageResponse(Message.SUCCESS_CREATION) ;
    }

    @Override
    public List<ApprovePrimaryOrders> getAllApprovePrimaryOrders() {
        return approvePrimaryOrderRepository.findAll();
    }

    @Override
    public ApprovePrimaryOrders getApprovePrimaryOrdersById(int id) {
        return approvePrimaryOrderRepository.findById(id).get();
    }

    @Override
    public List<ApprovePrimaryOrders> getApprovePrimaryOrdersByPrimaryApproveId(int id) {
        return approvePrimaryOrderRepository.findApprovePrimaryOrdersByPrimaryOrderApprovalId(id);
    }
}
