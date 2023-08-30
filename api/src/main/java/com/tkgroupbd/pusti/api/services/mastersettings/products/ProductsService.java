package com.tkgroupbd.pusti.api.services.mastersettings.products;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductsService {
    MessageResponse addProducts(ProductsRequest productsRequest);
    Optional<Products> updateProducts(Integer pId, ProductsRequest productsRequest);
    Optional<Products> statusChangeAPI(Integer pId, ProductsRequest productsRequest);
    void deleteProducts(Integer pId);
    Products getProductsById(Integer pId);
    List<Products> getAllProducts();

}
