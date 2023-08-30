package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.Offer;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.OfferRequest;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OfferService {
    public Offer saveOfferWithDetails(OfferRequest request);

    public Optional<Offer> updateOffer(int id, OfferRequest request);

    public List<Offer> getAllOffers();

    public Offer getOfferById(int id);

    public void deleteOfferById(int id);

}
