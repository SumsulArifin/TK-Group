package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Outlet;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.OutletRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.OutletRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutletServiceImpl implements OutletService {

    @Autowired
    OutletRepository outletRepository;

    @Override
    public MessageResponse createOutlet(OutletRequest outletRequest) {

        Outlet newOutlet = new Outlet();

        newOutlet.setName(outletRequest.getName());
        newOutlet.setContactPerson(outletRequest.getContactPerson());
        newOutlet.setMobile(outletRequest.getMobile());
        newOutlet.setAddress(outletRequest.getAddress());
        newOutlet.setSalesPerMonth(outletRequest.getSalesPerMonth());
        newOutlet.setOutletKey(outletRequest.getOutletKey());
        newOutlet.setChannelId(outletRequest.getChannelId());
        newOutlet.setDisplayed(outletRequest.isDisplayed());
        newOutlet.setPaidAmount(outletRequest.getPaidAmount());
        newOutlet.setCreditSalesId(outletRequest.getCreditSalesId());
        newOutlet.setBusinessType(outletRequest.getBusinessType());
        newOutlet.setStatus(outletRequest.isStatus());
        newOutlet.setCreatedAt(outletRequest.getCreatedAt());
        newOutlet.setUpdatedAt(outletRequest.getUpdatedAt());
        newOutlet.setDeletedAt(outletRequest.getDeletedAt());
        newOutlet.setBrowser(outletRequest.getBrowser());
        newOutlet.setIp(outletRequest.getIp());
        newOutlet.setRoute(outletRequest.getRoute());

        outletRepository.save(newOutlet);

        return new MessageResponse(Message.SUCCESS_OUTLET_CREATION);
    }

    @Override
    public Optional<Outlet> updateOutlet(Integer outletId, OutletRequest outletRequest) {
        Optional<Outlet> result = outletRepository.findById(outletId);

        if (result.isPresent()) {
            Outlet modifyingOutlet = result.get();

            modifyingOutlet.setName(outletRequest.getName());
            modifyingOutlet.setContactPerson(outletRequest.getContactPerson());
            modifyingOutlet.setMobile(outletRequest.getMobile());
            modifyingOutlet.setAddress(outletRequest.getAddress());
            modifyingOutlet.setSalesPerMonth(outletRequest.getSalesPerMonth());
            modifyingOutlet.setOutletKey(outletRequest.getOutletKey());
            modifyingOutlet.setChannelId(outletRequest.getChannelId());
            modifyingOutlet.setDisplayed(outletRequest.isDisplayed());
            modifyingOutlet.setPaidAmount(outletRequest.getPaidAmount());
            modifyingOutlet.setCreditSalesId(outletRequest.getCreditSalesId());
            modifyingOutlet.setBusinessType(outletRequest.getBusinessType());
            modifyingOutlet.setStatus(outletRequest.isStatus());
            modifyingOutlet.setCreatedAt(outletRequest.getCreatedAt());
            modifyingOutlet.setUpdatedAt(outletRequest.getUpdatedAt());
            modifyingOutlet.setDeletedAt(outletRequest.getDeletedAt());
            modifyingOutlet.setBrowser(outletRequest.getBrowser());
            modifyingOutlet.setIp(outletRequest.getIp());
            modifyingOutlet.setRoute(outletRequest.getRoute());

            outletRepository.save(modifyingOutlet);
        } else {
            throw new ResourceNotFoundException("Outlet", "id", outletId);
        }

        return result;
    }

    @Override
    public void deleteOutlet(Integer outletId) {
        outletRepository.deleteById(outletId);

    }

    @Override
    public Outlet getOutletById(Integer outletId) {
        return outletRepository.findById(outletId)
                .orElseThrow(() -> new ResourceNotFoundException("Outlet", "id", outletId));
    }

    @Override
    public List<Outlet> getAllOutlet() {
        return outletRepository.findAll();
    }

    @Override
    public List<Outlet> findOutletByZoneId(Integer id) {
        return null;// outletRepository.findOutletByZoneId(id);
    }

    @Override
    public List<Outlet> findByOutletName(String name) {
        List<Outlet> outlets = outletRepository.findByNameContaining(name);
        return outlets;
    }

    @Override
    public Optional<Outlet> outletStatusChange(Integer id, OutletRequest outletRequest) {
        Optional<Outlet> outlet = outletRepository.findById(id);
        if (outlet.isEmpty()) {
            throw new ResourceNotFoundException("Outlet", "id", id);
        } else
            outlet.get().setStatus(outletRequest.isStatus());
        outletRepository.save(outlet.get());
        return outlet;
    }
}
