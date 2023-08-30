package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.OfferType;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.OfferTypeRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OfferTypeService {
    MessageResponse createOfferType(OfferTypeRequest request);

    public Optional<OfferType> updateOfferType(int id, OfferTypeRequest request);

    public void deleteOfferTypeById(int id);

    public Optional<OfferType> updateOfferTypeStatus(int id, OfferTypeRequest request);

    public List<OfferType> getAllOfferType();

    public OfferType findOfferTypeById(int id);

    Page<OfferType> findOfferTypeByPagination(int offset, int pageSize);

    Page<OfferType> findSortedOfferTypeByPagination(int offset, int pageSize, String field);

}
