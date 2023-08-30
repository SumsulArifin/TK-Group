package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Outlet;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.OutletRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OutletService {
    MessageResponse createOutlet(OutletRequest outletRequest);

    Optional<Outlet> updateOutlet(Integer id, OutletRequest outletRequest);

    void deleteOutlet(Integer id);

    Outlet getOutletById(Integer id);

    List<Outlet> getAllOutlet();

    List<Outlet> findOutletByZoneId(Integer id);

    List<Outlet> findByOutletName(String name);

    Optional<Outlet> outletStatusChange(Integer id, OutletRequest outletRequest);
}
