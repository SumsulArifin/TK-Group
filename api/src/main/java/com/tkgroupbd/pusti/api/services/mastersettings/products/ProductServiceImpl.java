package com.tkgroupbd.pusti.api.services.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.*;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.*;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.products.ProductItemRepository;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.products.ProductMetaRepository;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.products.ProductPriceRepository;
import com.tkgroupbd.pusti.api.data.repositories.mastersettings.products.ProductRepository;
import com.tkgroupbd.pusti.api.exceptions.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductItemRepository productDetailRepository;

    @Autowired
    ProductPriceRepository productPriceRepository;

    @Autowired
    ProductMetaRepository productMetaRepository;

    @Override
    public MessageResponse addProduct(ProductRequest productRequest) {

        try {
            Product product = new Product();

            product.setName(productRequest.getName());
            product.setBengaliName(productRequest.getBengaliName());
            product.setStatus(productRequest.isStatus());
            product.setCreatedBy(productRequest.getCreatedBy());
            product.setUpdatedBy(productRequest.getUpdatedBy());
            product.setCreatedAt(productRequest.getCreatedAt());
            product.setUpdatedAt(productRequest.getUpdatedAt());
            product.setDeletedAt(productRequest.getDeletedAt());
            product.setBrowser(productRequest.getBrowser());
            product.setIp(productRequest.getIp());
            product.setCategory(productRequest.getCategory());

            // Save the product entity
            product = productRepository.save(product);

            /**
             * multiple product details save per product
             */

            // Loop through each productDetailRequest and convert to ProductDetail entity
            for (ProductItemRequest detailsRequest : productRequest.getProductDetailRequests()) {

                ProductItem productDetail = new ProductItem();
                productDetail.setProduct(product);

                productDetail.setSku(detailsRequest.getSku());
                productDetail.setErpId(detailsRequest.getErpId());
                productDetail.setSellableUnitId(detailsRequest.getSellableUnitId());
                productDetail.setWeight(detailsRequest.getWeight());
                productDetail.setPiecePerSale(detailsRequest.getPiecePerSale());
                productDetail.setPiecePerCartoon(detailsRequest.getPiecePerCartoon());
                productDetail.setOpeningDate(detailsRequest.getOpeningDate());
                productDetail.setImageName(detailsRequest.getImageName());
                productDetail.setCreatedBy(detailsRequest.getCreatedBy());
                productDetail.setUpdatedBy(detailsRequest.getUpdatedBy());
                productDetail.setCreatedAt(detailsRequest.getCreatedAt());
                productDetail.setUpdatedAt(detailsRequest.getUpdatedAt());
                productDetail.setDeletedAt(detailsRequest.getDeletedAt());
                productDetail.setBrowser(detailsRequest.getBrowser());
                productDetail.setIp(detailsRequest.getIp());

                // Save the productDetail entity
                productDetailRepository.save(productDetail);

                /**
                 * product price save as product details by single sku name
                 */

                ProductPriceRequest priceRequest = new ProductPriceRequest();
                ProductPrice productPrice = new ProductPrice();

                productPrice.setSku(detailsRequest.getSku());
                productPrice.setTradePrice(priceRequest.getTradePrice());
                productPrice.setDistributionPrice(priceRequest.getDistributionPrice());
                productPrice.setCreatedBy(priceRequest.getCreatedBy());
                productPrice.setUpdatedBy(priceRequest.getUpdatedBy());
                productPrice.setCreatedAt(priceRequest.getCreatedAt());
                productPrice.setUpdatedAt(priceRequest.getUpdatedAt());
                productPrice.setDeletedAt(priceRequest.getDeletedAt());
                productPrice.setBrowser(priceRequest.getBrowser());
                productPrice.setIp(priceRequest.getIp());

                productPriceRepository.save(productPrice);
            }
            /**
             * product image save as one product image by single sku name
             */
            for (ProductMetaRequest productMetaRequest : productRequest.getProductMetaRequests()) {
                ProductMeta productMeta = new ProductMeta();
                productMeta.setProduct(product);
                productMeta.setKey(productMetaRequest.getKey());
                productMeta.setContent(productMetaRequest.getContent());
                productMeta.setCreatedBy(productMetaRequest.getCreatedBy());
                productMeta.setUpdatedBy(productMetaRequest.getUpdatedBy());
                productMeta.setCreatedAt(productMetaRequest.getCreatedAt());
                productMeta.setUpdatedAt(productMetaRequest.getUpdatedAt());
                productMeta.setDeletedAt(productMetaRequest.getDeletedAt());
                productMeta.setBrowser(productMetaRequest.getBrowser());
                productMeta.setIp(productMetaRequest.getIp());
                // productMeta.setProduct(productMetaRequest.getProduct());

                productMetaRepository.save(productMeta);
            }

            return new MessageResponse(Message.SUCCESS_CREATION);
        } catch (Exception e) {
            return new MessageResponse(Message.FAILED_CREATION);
        }

    }

    @Override
    public Optional<Product> statusChangeAPI(Integer pId, ProductRequest productRequest) {
        Optional<Product> product = productRepository.findById(pId);
        if (product.isEmpty()) {
            throw new ResourceNotFoundException("Product", "pId", pId);
        } else
            product.get().setStatus(productRequest.isStatus());
        ;
        productRepository.save(product.get());
        return product;
    }

    @Override
    public List<Object[]> getAllProduct() {
        return productRepository.findAllProducts();
    }

    @Override
    public Product getProductById(Integer pId) {
        return null;
    }

    @Override
    public Optional<Product> updateProductDetailsAndPrice(String sku, ProductRequest productsRequest) {

        return Optional.empty();
    }

    @Override
    public List<Object> findAllProductInformationByPrdouctId(int productId) {
        return productRepository.findAllInformations(productId);

    }

    @Override
    public MessageResponse updateProduct(int productId, ProductRequest productRequest) {
        List<Object> objects = productRepository.findAllInformations(productId);

        try {
            // Retrieve the existing product entity
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (!optionalProduct.isPresent()) {
                return new MessageResponse(Message.FAILED_UPDATE);
            }
            Product product = optionalProduct.get();

            // Update the product entity with the new values from the request

            product.setName(productRequest.getName());
            product.setBengaliName(productRequest.getBengaliName());
            product.setStatus(productRequest.isStatus());
            product.setCreatedBy(productRequest.getCreatedBy());
            product.setUpdatedBy(productRequest.getUpdatedBy());
            product.setCreatedAt(productRequest.getCreatedAt());
            product.setUpdatedAt(productRequest.getUpdatedAt());
            product.setDeletedAt(productRequest.getDeletedAt());
            product.setBrowser(productRequest.getBrowser());
            product.setIp(productRequest.getIp());
            product.setCategory(productRequest.getCategory());

            // Save the updated product entity
            product = productRepository.save(product);

            // Update product details
            for (ProductItemRequest detailsRequest : productRequest.getProductDetailRequests()) {
                // Check if the detail exists, and update if necessary
                Optional<ProductItem> optionalDetail = productDetailRepository.findById(detailsRequest.getProDetailsId());
                if (optionalDetail.isPresent()) {
                    ProductItem productDetail = optionalDetail.get();

                    productDetail.setSku(detailsRequest.getSku());
                    productDetail.setErpId(detailsRequest.getErpId());
                    productDetail.setSellableUnitId(detailsRequest.getSellableUnitId());
                    productDetail.setWeight(detailsRequest.getWeight());
                    productDetail.setPiecePerSale(detailsRequest.getPiecePerSale());
                    productDetail.setPiecePerCartoon(detailsRequest.getPiecePerCartoon());
                    productDetail.setOpeningDate(detailsRequest.getOpeningDate());
                    productDetail.setImageName(detailsRequest.getImageName());
                    productDetail.setCreatedBy(detailsRequest.getCreatedBy());
                    productDetail.setUpdatedBy(detailsRequest.getUpdatedBy());
                    productDetail.setCreatedAt(detailsRequest.getCreatedAt());
                    productDetail.setUpdatedAt(detailsRequest.getUpdatedAt());
                    productDetail.setDeletedAt(detailsRequest.getDeletedAt());
                    productDetail.setBrowser(detailsRequest.getBrowser());
                    productDetail.setIp(detailsRequest.getIp());

                    // Save the updated productDetail entity
                    productDetailRepository.save(productDetail);

                }

                for (ProductPriceRequest priceRequest : productRequest.getProductPriceRequests()) {
                    // Check if the detail exists, and update if necessary
                    Optional<ProductPrice> optionalPrice = productPriceRepository.findBySku(detailsRequest.getSku());
                    if (optionalPrice.isPresent()) {
                        ProductPrice productPrice = optionalPrice.get();

                        productPrice.setSku(detailsRequest.getSku());
                        productPrice.setTradePrice(priceRequest.getTradePrice());
                        productPrice.setDistributionPrice(priceRequest.getDistributionPrice());
                        productPrice.setCreatedBy(priceRequest.getCreatedBy());
                        productPrice.setUpdatedBy(priceRequest.getUpdatedBy());
                        productPrice.setCreatedAt(priceRequest.getCreatedAt());
                        productPrice.setUpdatedAt(priceRequest.getUpdatedAt());
                        productPrice.setDeletedAt(priceRequest.getDeletedAt());
                        productPrice.setBrowser(priceRequest.getBrowser());
                        productPrice.setIp(priceRequest.getIp());

                        // Save the updated productDetail entity
                        productPriceRepository.save(productPrice);

                    }
                }
            }

            for (ProductMetaRequest productMetaRequest : productRequest.getProductMetaRequests()) {
                Optional<ProductMeta> optionalMeta = productMetaRepository.findById(productMetaRequest.getProMetaId());
                if (optionalMeta.isPresent()) {
                    ProductMeta productMeta = optionalMeta.get();
                    productMeta.setKey(productMetaRequest.getKey());

                    productMeta.setProduct(product);
                    productMeta.setContent(productMetaRequest.getContent());
                    productMeta.setImageUrl(productMeta.getImageUrl());
                    productMeta.setCreatedBy(productMetaRequest.getCreatedBy());
                    productMeta.setUpdatedBy(productMetaRequest.getUpdatedBy());
                    productMeta.setCreatedAt(productMetaRequest.getCreatedAt());
                    productMeta.setUpdatedAt(productMetaRequest.getUpdatedAt());
                    productMeta.setDeletedAt(productMetaRequest.getDeletedAt());
                    productMeta.setBrowser(productMetaRequest.getBrowser());
                    productMeta.setIp(productMetaRequest.getIp());

                    // Save the updated productMeta entity
                    productMetaRepository.save(productMeta);

                }
            }

            return new MessageResponse(Message.SUCCESS_UPDATE);

        } catch (Exception e) {
            return new MessageResponse(Message.FAILED_UPDATE);
        }
    }
}
