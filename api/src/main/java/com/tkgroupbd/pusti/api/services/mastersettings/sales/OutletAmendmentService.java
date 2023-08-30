package com.tkgroupbd.pusti.api.services.mastersettings.sales;


import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.OutletAmendment;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.OutletAmendmentRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Optional;


@Component
public interface OutletAmendmentService {


    MessageResponse createOutletAmendment(List<OutletAmendmentRequest> outletAmendmentRequestList);

    public List<OutletAmendment> updateBulkOutletAmendments(List<OutletAmendmentRequest> outletAmendmentRequestList);

    public Optional<OutletAmendment> updateOutletAmendmentLatitudeAndLongitude(int id, OutletAmendmentRequest request);

    }