package com.tkgroupbd.pusti.api.services.secondaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.DeliveredProduct;
import com.tkgroupbd.pusti.api.data.payloads.requests.secondaryorders.DeliveredProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.secondaryorders.DeliveredProductRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Service
public class DeliveredProductServiceImpl implements DeliveredProductService {

    @Autowired
    @SuppressWarnings(Message.AUTOWIRED_OK)
    private DeliveredProductRepository repository;

    @Override
    public MessageResponse createDeliveredProduct(DeliveredProductRequest request) {
        try {
            DeliveredProduct deliveredProduct = new DeliveredProduct();

            deliveredProduct.setScheduleOutlet(request.getScheduleOutlet());
            deliveredProduct.setVisitedOutlet(request.getVisitedOutlet());
            deliveredProduct.setQuantity(request.getQuantity());
            deliveredProduct.setReceivedFrom(request.getReceivedFrom());
            deliveredProduct.setDeliveryStatus(request.getDeliveryStatus());
            deliveredProduct.setProductItem(request.getProductItem());
            deliveredProduct.setOutletAmendment(request.getOutletAmendment());
            deliveredProduct.setAssignedSalesOfficer(request.getAssignedSalesOfficer());
            deliveredProduct.setCreatedAt(request.getCreatedAt());
            deliveredProduct.setUpdatedAt(request.getUpdatedAt());
            deliveredProduct.setDeletedAt(request.getDeletedAt());


            repository.save(deliveredProduct);
            return new MessageResponse(Message.SUCCESS_CREATION);
        } catch (Exception e) {
            return new MessageResponse(Message.FAILED_CREATION);
        }
    }

    @Override
    public Optional<DeliveredProduct> updateDeliveredProduct(Integer id, DeliveredProductRequest request) {

        Optional<DeliveredProduct> result = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("DeliveredProduct", "id", id)));

        if (result.isPresent()) {
            DeliveredProduct deliveredProduct = result.get();

            deliveredProduct.setScheduleOutlet(request.getScheduleOutlet());
            deliveredProduct.setVisitedOutlet(request.getVisitedOutlet());
            deliveredProduct.setQuantity(request.getQuantity());
            deliveredProduct.setReceivedFrom(request.getReceivedFrom());
            deliveredProduct.setDeliveryStatus(request.getDeliveryStatus());
            deliveredProduct.setProductItem(request.getProductItem());
            deliveredProduct.setOutletAmendment(request.getOutletAmendment());
            deliveredProduct.setAssignedSalesOfficer(request.getAssignedSalesOfficer());
            deliveredProduct.setCreatedAt(request.getCreatedAt());
            deliveredProduct.setUpdatedAt(request.getUpdatedAt());
            deliveredProduct.setDeletedAt(request.getDeletedAt());

            repository.save(deliveredProduct);
        } else {
            throw new ResourceNotFoundException("DeliveredProduct", "id", id);
        }
        return result;
    }

    @Override
    public DeliveredProduct getDeliveredProductById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DeliveredProduct", "id", id));
    }

    @Override
    public List<DeliveredProduct> getAllDeliveredProduct() {
        return repository.findAll();
    }

    @Override
    public List<DeliveredProduct> getAllByDateRange(LocalDate startDate, LocalDate endDate) {
        return repository.findByCreatedAtBetween(startDate, endDate);
    }

    @Override
    public List<DeliveredProduct> findByCreatedAt(LocalDate createdAt) {
        return repository.findByCreatedAt(createdAt);
    }

    @Override
    public List<DeliveredProduct> findByCreatedAts(LocalDate createdAt) {
        ;
        List<DeliveredProduct> products = repository.findByCreatedAt(createdAt);
        return products;
    }

    @Override
    public List<DeliveredProduct> findByCreated(LocalDate createdAt) {
        List<DeliveredProduct> products = repository.findByCreatedAt(createdAt);
        return products;
    }

}
