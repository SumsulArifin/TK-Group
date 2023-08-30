package com.tkgroupbd.pusti.api.controllers.secondaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.DeliveredProduct;
import com.tkgroupbd.pusti.api.data.payloads.requests.secondaryorders.DeliveredProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.secondaryorders.DeliveredProductServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Tag(name="Delivered Product")
@RestController
@RequestMapping("/deliveredProduct")
public class DeliveredProductController {
    @Autowired
    private DeliveredProductServiceImpl deliveredProductService;
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addDeliveredProduct(@RequestBody DeliveredProductRequest request) {
        MessageResponse deliveredProduct = deliveredProductService.createDeliveredProduct(request);
        return new ResponseEntity<>(deliveredProduct, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<DeliveredProduct>> updateDeliveredProduct(@PathVariable Integer id,
                                                                             @RequestBody DeliveredProductRequest request) {
        Optional<DeliveredProduct> salesOrderRemark = deliveredProductService.updateDeliveredProduct(id, request);
        return new ResponseEntity<Optional<DeliveredProduct>>(salesOrderRemark, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DeliveredProduct>> getAllDeliveredProduct() {
        List<DeliveredProduct> deliveredProduct = deliveredProductService.getAllDeliveredProduct();
        return new ResponseEntity<>(deliveredProduct, HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<DeliveredProduct> getSalesOrderRemarkById(@PathVariable("id") Integer id) {
        DeliveredProduct deliveredProduct = deliveredProductService.getDeliveredProductById(id);
        return new ResponseEntity<>(deliveredProduct, HttpStatus.OK);
    }

    /**
     * http://localhost:8080/deliveredProduct/date/between?startDate=2023-07-19&endDate=2023-08-21
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/date/between")
    public ResponseEntity<List<DeliveredProduct>> searchDeliveredProductByDate(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        List<DeliveredProduct> deliveredProducts = deliveredProductService.getAllByDateRange(startDate, endDate);
        return ResponseEntity.ok(deliveredProducts);
    }

    @GetMapping("/byCreatedAt")
    public ResponseEntity<List<DeliveredProduct>> getProductsByCreatedAt(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createdAt){
        List<DeliveredProduct> products = deliveredProductService.findByCreatedAts(createdAt);
        return ResponseEntity.ok(products);
    }

}
