package com.tkgroupbd.pusti.api.services.secondaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.DeliveredProduct;
import com.tkgroupbd.pusti.api.data.payloads.requests.secondaryorders.DeliveredProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public interface DeliveredProductService {
    public MessageResponse createDeliveredProduct(DeliveredProductRequest request);
    public Optional<DeliveredProduct> updateDeliveredProduct(Integer id, DeliveredProductRequest request);
    public DeliveredProduct getDeliveredProductById(Integer id);
    public List<DeliveredProduct> getAllDeliveredProduct();
    public List<DeliveredProduct> getAllByDateRange(LocalDate startDate, LocalDate endDate);
    public List<DeliveredProduct> findByCreatedAt(LocalDate createdAt);
    public List<DeliveredProduct> findByCreatedAts(LocalDate createdAt);
    public List<DeliveredProduct> findByCreated(LocalDate createdAt);
}
