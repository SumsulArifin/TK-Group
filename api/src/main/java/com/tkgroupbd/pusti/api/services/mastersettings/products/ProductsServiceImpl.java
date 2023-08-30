package com.tkgroupbd.pusti.api.services.mastersettings.products;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.products.ProductsRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public MessageResponse addProducts(ProductsRequest productsRequest) {
        Products products= new Products();
        products.setCategory(productsRequest.getCategory());
       products.setName(productsRequest.getName());
       products.setBengaliName(productsRequest.getBengaliName());
       products.setDistributionPrice(productsRequest.getDistributionPrice());
       products.setTradePrice(productsRequest.getTradePrice());
       products.setUnitId(productsRequest.getUnitId());
       products.setERPId(productsRequest.getERPId());
       products.setWeight(productsRequest.getWeight());
       products.setPiecePerSale(productsRequest.getPiecePerSale());
       products.setPiecePerCTN(productsRequest.getPiecePerCTN());
       products.setOpeningDate(productsRequest.getOpeningDate());
       products.setImageName(productsRequest.getImageName());
       products.setStatus(productsRequest.isStatus());
       products.setCreatedAt(productsRequest.getCreatedAt());
       products.setUpdatedAt(productsRequest.getUpdatedAt());
       products.setDeletedAt(productsRequest.getDeletedAt());
       products.setBrowser(productsRequest.getBrowser());
       products.setIp(productsRequest.getIp());
        productsRepository.save( products);
        return new MessageResponse(Message.SUCCESS_DEPOT_CREATION);
    }

    @Override
    public Optional<Products> updateProducts(Integer pId, ProductsRequest productsRequest) {

        Optional<Products> result = productsRepository.findById(pId);

        if (result.isPresent()) {
            Products products = result.get();

            products.setCategory(productsRequest.getCategory());
            products.setName(productsRequest.getName());
            products.setBengaliName(productsRequest.getBengaliName());
            products.setDistributionPrice(productsRequest.getDistributionPrice());
            products.setTradePrice(productsRequest.getTradePrice());
            products.setUnitId(productsRequest.getUnitId());
            products.setERPId(productsRequest.getERPId());
            products.setWeight(productsRequest.getWeight());
            products.setPiecePerSale(productsRequest.getPiecePerSale());
            products.setPiecePerCTN(productsRequest.getPiecePerCTN());
            products.setOpeningDate(productsRequest.getOpeningDate());
            products.setImageName(productsRequest.getImageName());
            products.setStatus(productsRequest.isStatus());
            products.setCreatedAt(productsRequest.getCreatedAt());
            products.setUpdatedAt(productsRequest.getUpdatedAt());
            products.setDeletedAt(productsRequest.getDeletedAt());
            products.setBrowser(productsRequest.getBrowser());
            products.setIp(productsRequest.getIp());
            productsRepository.save(products);
        } else {
            throw new ResourceNotFoundException("Products", "pId", pId);
        }

        return result;
    }

    @Override
    public Optional<Products> statusChangeAPI(Integer pId, ProductsRequest productsRequest) {
        Optional<Products> products = productsRepository.findById(pId);
        if (products.isEmpty()) {
            throw new ResourceNotFoundException("Products", "pId", pId);
        } else
            products.get().setStatus(productsRequest.isStatus());
        ;
        productsRepository.save(products.get());
        return products;
    }

    @Override
    public void deleteProducts(Integer pId) {
        productsRepository.deleteById(pId);

    }

    @Override
    public Products getProductsById(Integer pId) {
        return productsRepository.findById(pId).get();
    }

    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }
}
