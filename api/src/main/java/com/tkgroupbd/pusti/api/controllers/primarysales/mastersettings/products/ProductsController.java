package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Products;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.ProductsRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.products.ProductsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Product")
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    // Create a new Products
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addProducts(@RequestBody ProductsRequest productsRequest) {
        MessageResponse newProducts = productsService.addProducts(productsRequest);
        return new ResponseEntity<>(newProducts, HttpStatus.CREATED);
    }

    // Update a Products information
    @PutMapping("/update/{pId}")
    public ResponseEntity<Optional<Products>> updateProducts(@PathVariable Integer pId,
            @RequestBody ProductsRequest productsRequest) {
        Optional<Products> updateProducts = productsService.updateProducts(pId, productsRequest);
        return new ResponseEntity<Optional<Products>>(updateProducts, HttpStatus.OK);
    }

    // Products Status Change API
    @PutMapping("/changeStatus/{pId}")
    public ResponseEntity<Optional<Products>> changeProductsStatus(@PathVariable Integer pId,
            @RequestBody ProductsRequest productsRequest) {
        Optional<Products> updateProductsStatus = productsService.statusChangeAPI(pId, productsRequest);
        return new ResponseEntity<Optional<Products>>(updateProductsStatus, HttpStatus.OK);
    }

    // get All Products
    @GetMapping("/getAll")
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productsService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Delete Products by id
    @DeleteMapping("/delete/{pId}")
    public ResponseEntity<?> deleteProducts(@PathVariable("pId") Integer pId) {
        productsService.deleteProducts(pId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Find by id Products Api
    @GetMapping("/getById/{pId}")
    public ResponseEntity<Products> getProductById(@PathVariable("pId") Integer pId) {
        Products products = productsService.getProductsById(pId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
