package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Product;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.products.ProductServiceImpl;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "ProductAndProductDetailsAndProductPrice")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addProduct(@RequestBody ProductRequest productRequest) {
        MessageResponse newProduct = productService.addProduct(productRequest);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }


    @PutMapping("/update/{productId}")
    public ResponseEntity<MessageResponse> updateProduct(
            @PathVariable int productId,
            @RequestBody ProductRequest updatedProductRequest) {

        MessageResponse response = productService.updateProduct(productId, updatedProductRequest);

        HttpStatus status = (response.getMessage().equals(Message.SUCCESS_CREATION)) ?
                HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(response, status);
    }

    @PutMapping("/changeStatus/{pId}")
    public ResponseEntity<Optional<Product>> changeProductsStatus(@PathVariable Integer pId,
                                                                   @RequestBody ProductRequest productRequest) {
        Optional<Product> updateProductStatus = productService.statusChangeAPI(pId, productRequest);
        return new ResponseEntity<Optional<Product>>(updateProductStatus, HttpStatus.OK);
    }


    @GetMapping("/product/all/byId/{id}")
    public List<Object> getAllById(@PathVariable("id") int id) {
        List<Object> product = productService.findAllProductInformationByPrdouctId(id);
        return product;
    }

    @GetMapping("/all/information")
    public ResponseEntity<List<Object[]>> getAllProductsWithOtherInformation() {
        List<Object[]> product = productService.getAllProduct();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


}
