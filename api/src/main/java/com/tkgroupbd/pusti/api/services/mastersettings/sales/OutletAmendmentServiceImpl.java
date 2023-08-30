package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.OutletAmendment;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.DailyOrdersSummary;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.OutletAmendmentRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.DailyOrdersSummaryRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.sales.OutletAmendmentRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OutletAmendmentServiceImpl implements OutletAmendmentService {
    @Autowired
    private OutletAmendmentRepository outletAmendmentRepository;


    @Override
    public MessageResponse createOutletAmendment(List<OutletAmendmentRequest> outletAmendmentRequestList) {
        try {
            List<OutletAmendment> createdOutletAmendments = new ArrayList<>();

            for (OutletAmendmentRequest request : outletAmendmentRequestList) {
                OutletAmendment outletAmendment = new OutletAmendment();

                outletAmendment.setEnglishName(request.getEnglishName());
                outletAmendment.setBanglaName(request.getBanglaName());
                outletAmendment.setEnglishAddress(request.getEnglishAddress());
                outletAmendment.setBanglaAddress(request.getBanglaAddress());
                outletAmendment.setContactPerson(request.getContactPerson());
                outletAmendment.setMobile(request.getMobile());
                outletAmendment.setBusinessType(request.getBusinessType());
                outletAmendment.setSalesPerMonth(request.getSalesPerMonth());
                outletAmendment.setOutletKey(request.getOutletKey());
                outletAmendment.setShopSign(request.getShopSign());
                outletAmendment.setCreditSales(request.getCreditSales());
                outletAmendment.setComments(request.getComments());
                outletAmendment.setShopSignAmount(request.getShopSignAmount());
                outletAmendment.setLatitude(request.getLatitude());
                outletAmendment.setLongitude(request.getLongitude());
                outletAmendment.setChannelId(request.getChannelId());
                outletAmendment.setSalesGroup(request.getSalesGroup());
                outletAmendment.setMarketSize(request.getMarketSize());
                outletAmendment.setCreatedAt(request.getCreatedAt());
                outletAmendment.setCreatedBy(request.getCreatedBy());
                outletAmendment.setUpdatedAt(request.getUpdatedAt());
                outletAmendment.setUpdatedBy(request.getUpdatedBy());
                outletAmendment.setDeletedAt(request.getDeletedAt());
                outletAmendment.setDeletedBy(request.getDeletedBy());
                outletAmendment.setIp(request.getIp());
                outletAmendment.setBrowser(request.getBrowser());
                outletAmendment.setStatus(request.isStatus());


                outletAmendment.setRoute(request.getRoute());
                outletAmendment.setSalesOfficer(request.getSalesOfficer());


                createdOutletAmendments.add(outletAmendment);
            }
            outletAmendmentRepository.saveAll(createdOutletAmendments);
            return new MessageResponse(Message.SUCCESS_CREATION);
        } catch (Exception e) {
            return new MessageResponse(Message.FAILED_CREATION);
        }
    }


    @Override
    public List<OutletAmendment> updateBulkOutletAmendments(List<OutletAmendmentRequest> outletAmendmentRequestList) {

        try {

            List<OutletAmendment> updatedOutletAmendments = new ArrayList<>();

            for (OutletAmendmentRequest request : outletAmendmentRequestList) {
                OutletAmendment outletAmendment = outletAmendmentRepository.findById(request.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Outlet Amendment with id " + request.getId() + " not found"));

                outletAmendment.setEnglishName(request.getEnglishName());
                outletAmendment.setBanglaName(request.getBanglaName());
                outletAmendment.setEnglishAddress(request.getEnglishAddress());
                outletAmendment.setBanglaAddress(request.getBanglaAddress());
                outletAmendment.setContactPerson(request.getContactPerson());
                outletAmendment.setMobile(request.getMobile());
                outletAmendment.setBusinessType(request.getBusinessType());
                outletAmendment.setSalesPerMonth(request.getSalesPerMonth());
                outletAmendment.setOutletKey(request.getOutletKey());
                outletAmendment.setShopSign(request.getShopSign());
                outletAmendment.setCreditSales(request.getCreditSales());
                outletAmendment.setComments(request.getComments());
                outletAmendment.setShopSignAmount(request.getShopSignAmount());
                outletAmendment.setLatitude(request.getLatitude());
                outletAmendment.setLongitude(request.getLongitude());
                outletAmendment.setChannelId(request.getChannelId());
                outletAmendment.setSalesGroup(request.getSalesGroup());
                outletAmendment.setMarketSize(request.getMarketSize());
                outletAmendment.setCreatedAt(request.getCreatedAt());
                outletAmendment.setCreatedBy(request.getCreatedBy());
                outletAmendment.setUpdatedAt(request.getUpdatedAt());
                outletAmendment.setUpdatedBy(request.getUpdatedBy());
                outletAmendment.setDeletedAt(request.getDeletedAt());
                outletAmendment.setDeletedBy(request.getDeletedBy());
                outletAmendment.setIp(request.getIp());
                outletAmendment.setBrowser(request.getBrowser());
                outletAmendment.setStatus(request.isStatus());
                outletAmendment.setRoute(request.getRoute());
                outletAmendment.setSalesOfficer(request.getSalesOfficer());


                updatedOutletAmendments.add(outletAmendment);
            }

            return outletAmendmentRepository.saveAll(updatedOutletAmendments);
        } catch (Exception e) {
            return null;
        }

    }


    @Override
    public Optional<OutletAmendment> updateOutletAmendmentLatitudeAndLongitude(int id, OutletAmendmentRequest request) {
        Optional<OutletAmendment> result = outletAmendmentRepository.findById(id);
        if (result.isPresent()) {
            OutletAmendment outletAmendment = result.get();
            outletAmendment.setLatitude(request.getLatitude());
            outletAmendment.setLongitude(request.getLongitude());

            outletAmendmentRepository.save(outletAmendment);
        } else {
            throw new ResourceNotFoundException("OutletAmendment", "id", id);
        }
        return result;
    }

}
