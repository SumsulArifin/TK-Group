package com.tkgroupbd.pusti.api.services.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Product;

import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductService {
    public MessageResponse addProduct(ProductRequest productRequest);
    public Optional<Product> statusChangeAPI(Integer pId, ProductRequest productRequest);
    public List<Object[]> getAllProduct();
    public Product getProductById(Integer pId);
    public Optional<Product> updateProductDetailsAndPrice(String sku, ProductRequest productsRequest);
    public List<Object> findAllProductInformationByPrdouctId(int productId);
    public MessageResponse updateProduct(int productId, ProductRequest productRequest);
}
