package com.tkgroupbd.pusti.api.services.mastersettings.sales;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.SalesTarget;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.SalesTargetRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public interface SalesTargetServices {

    MessageResponse addSalesTarget(SalesTargetRequest sales_targetRequest);
    Optional<SalesTarget> updateSalesTarget(Integer id, SalesTargetRequest sales_targetRequest);
    Optional<SalesTarget> statusChangeAPI(Integer id, SalesTargetRequest sales_targetRequest);
    void deleteSalesTarget(Integer id);
    SalesTarget getSalesTargetById(Integer id);
    List<SalesTarget> getAllSalesTarget();

    List<SalesTarget> findSortedSalesTargetByKey(String field);
    Page<SalesTarget> findSalesTargetByPagination(int offset, int pageSize);

    Page<SalesTarget> findSortedSalesTargetByPagination(int offset, int pageSize, String field);





}
