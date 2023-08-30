package com.tkgroupbd.pusti.api.services.primaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.Offer;
import com.tkgroupbd.pusti.api.data.models.entity.primaryorders.OfferDetails;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.OfferDetailsRequest;
import com.tkgroupbd.pusti.api.data.payloads.requests.primaryorders.OfferRequest;
import com.tkgroupbd.pusti.api.data.repositories.primaryorders.OfferDetailsRepository;
import com.tkgroupbd.pusti.api.data.repositories.primaryorders.OfferRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferDetailsRepository offerDetailsRepository;

    @Override
    public Offer saveOfferWithDetails(OfferRequest request) {
        // Convert OfferDTO to Offer entity
        Offer offer = new Offer();
        offer.setName(request.getName());
        offer.setOfferType(request.getOfferType());
        offer.setStatus(request.isStatus());

        offer.setStartDate(request.getStartDate());
        offer.setEndDate(request.getEndDate());
        offer.setCreatedBy(request.getCreatedBy());
        offer.setUpdatedBy(request.getUpdatedBy());
        offer.setCreatedAt(request.getCreatedAt());
        offer.setUpdatedAt(request.getUpdatedAt());
        offer.setDeletedAt(request.getDeletedAt());

        // Save the Offer entity
        offer = offerRepository.save(offer);

        // Loop through each OfferDetailRequest and convert to OfferDetail entity
        for (OfferDetailsRequest detailsRequest : request.getOfferDetailsRequests()) {
            OfferDetails offerDetail = new OfferDetails();
            offerDetail.setOffer(offer);
            offerDetail.setOfferIn(detailsRequest.getOfferIn());
            offerDetail.setOfferedUnitId(detailsRequest.getOfferedUnitId());
            offerDetail.setFromQuantity(detailsRequest.getFromQuantity());
            offerDetail.setToQuantity(detailsRequest.getToQuantity());
            offerDetail.setComboCriteria(detailsRequest.getComboCriteria());
            offerDetail.setOfferedQuantity(detailsRequest.getOfferedQuantity());
            offerDetail.setOfferedTaka(detailsRequest.getOfferedTaka());
            offerDetail.setCreatedBy(detailsRequest.getCreatedBy());
            offerDetail.setUpdatedBy(detailsRequest.getUpdatedBy());
            offerDetail.setCreatedAt(detailsRequest.getCreatedAt());
            offerDetail.setUpdatedAt(detailsRequest.getUpdatedAt());
            offerDetail.setDeletedAt(detailsRequest.getDeletedAt());

            // Save the OfferDetail entity
            offerDetailsRepository.save(offerDetail);
        }

        return offer;
    }

    @Override
    public Optional<Offer> updateOffer(int id, OfferRequest request) {
        Optional<Offer> result = offerRepository.findById(id);

        if (result.isPresent()) {
            Offer offer = result.get();

            offer.setName(request.getName());
            offer.setOfferType(request.getOfferType());
            offer.setStatus(request.isStatus());
            offer.setStartDate(request.getStartDate());
            offer.setEndDate(request.getEndDate());
            offer.setCreatedBy(request.getCreatedBy());
            offer.setUpdatedBy(request.getUpdatedBy());
            offer.setCreatedAt(request.getCreatedAt());
            offer.setUpdatedAt(request.getUpdatedAt());
            offer.setDeletedAt(request.getDeletedAt());

            // Save the Offer entity
            offerRepository.save(offer);

        } else {
            throw new ResourceNotFoundException("Offer", "id", id);
        }

        return result;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer getOfferById(int id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offer ", "id", id));
    }

    @Override
    public void deleteOfferById(int id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Offer  ", "id", id));

        // Delete associated OfferDetails before deleting the Offer
        List<OfferDetails> offerDetails = offerDetailsRepository.findOfferDetailsByOfferId(id);
        offerDetailsRepository.deleteAll(offerDetails);
        offerRepository.delete(offer);
    }
}
