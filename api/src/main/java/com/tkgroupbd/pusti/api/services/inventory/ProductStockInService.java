package com.tkgroupbd.pusti.api.services.inventory;

import com.tkgroupbd.pusti.api.data.models.entity.inventory.ProductStockIn;
import com.tkgroupbd.pusti.api.data.models.enums.ReceivedFrom;
import com.tkgroupbd.pusti.api.data.payloads.requests.inventory.ProductStockInRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductStockInService {
    MessageResponse createCollectProduct(ProductStockInRequest request);
    public Optional<ProductStockIn> updateProduct(int id, ProductStockInRequest request);
    List<ProductStockIn> getAllByCreationDateDesc();
    public List<ProductStockIn> getByCreatedAt(String createdAt);
    public List<ProductStockIn> findByReceivedFrom(ReceivedFrom receivedFrom);
}
