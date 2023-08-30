package com.tkgroupbd.pusti.api.controllers.secondaryorders;

import com.tkgroupbd.pusti.api.data.models.entity.secondaryorders.PendingProduct;
import com.tkgroupbd.pusti.api.data.payloads.requests.secondaryorders.PendingProductRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.secondaryorders.PendingProductServiceImpl;
import com.tkgroupbd.pusti.api.utils.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pendingProduct")
public class PendingProductController {
    @Autowired
    @SuppressWarnings(Message.AUTOWIRED_OK)
    private PendingProductServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPendingProduct(@RequestBody PendingProductRequest request){
        MessageResponse messageResponse = service.createPendingProduct(request);
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    /**
     * http://localhost:8080/pendingProduct/by-date?createdAt=2023-07-16
     * @return
     */
    @GetMapping("/by-date")
    public List<PendingProduct> getPendingProductsByDate() {
        return service.getPendingProductsByDate();
    }

    @GetMapping("/by-date/between")
    public ResponseEntity<List<PendingProduct>> getPendingProductByDateBetween(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate
    ) {
        List<PendingProduct> pendingProductList = service.getPendingProductsByDateBetween(startDate,endDate);
        return ResponseEntity.ok(pendingProductList);
    }

    /**
     * http://localhost:8080/pendingProduct/by_date/sku?startDate=2023-07-16&sku=string
     * @param startDate
     * @param sku
     * @return
     */
    @GetMapping("/by-date/sku")
    public ResponseEntity<List<PendingProduct>> getPendingProductByDateAndSku(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam String sku
    ) {
        List<PendingProduct> pendingProductList = service.findPendingProductByCreatedAtAndSku(startDate,sku);
        return ResponseEntity.ok(pendingProductList);
    }

    /**
     * http://localhost:8080/pendingProduct/by_date/previousDay?date=2023-08-16&howMany=15
     * date  = any date(YYYY-MM-dd) format
     * howMany = how many days need to see records
     * @param date
     * @param howMany
     * @return
     */
    @GetMapping("/by-date/previousDay")
    public ResponseEntity<List<PendingProduct>> getPendingProductByDateBetweenPreviousDay(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestParam int howMany) {
        List<PendingProduct> pendingProductList = service.getByCreatedAtBetweenLastManualDays(date, howMany);
        return ResponseEntity.ok(pendingProductList);
    }

    /**
     * firstly find all pending product that status is false
     * secondly add data in delevery product table
     * @return
     */
    @PostMapping("/add/pending/to/delevery")
    public ResponseEntity<MessageResponse> addPendingProductDelevery(){
        MessageResponse messageResponse = service.addAllInDeliveredFormPending();
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @GetMapping("/byOrderId/{id}")
    public ResponseEntity<List<PendingProduct>> getByApproveOrderId(
            @PathVariable("id") int id ){
        List<PendingProduct> pendingProductList = service.getAllPendingProductsByOrderId(id);
        return ResponseEntity.ok(pendingProductList);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PendingProduct>> getAllPendingProduct(){
        List<PendingProduct> pendingProductList = service.getAllPendingProducts();
        return ResponseEntity.ok(pendingProductList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<PendingProduct>> updatePendingProducts(@PathVariable Integer id, @RequestBody PendingProductRequest request) {
        Optional<PendingProduct> pendingProduct = service.updatePendingProduct(id, request);
        return new ResponseEntity<Optional<PendingProduct>>(pendingProduct, HttpStatus.OK);
    }

    @PutMapping("/delevery/add/pending/update/{id}")
    public ResponseEntity<MessageResponse> updatePendingProductQuantityAndAddToDeleveryProduct(@PathVariable Integer id, @RequestBody PendingProductRequest request) {
        MessageResponse messageResponse = service.updatePendingProductQuantityAndAddToDeleveryProduct(id, request);
        return  new ResponseEntity<>(messageResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/status/{id}")
    public ResponseEntity<Optional<PendingProduct>> updatePendingProductStatus(@PathVariable Integer id, @RequestBody PendingProductRequest request) {
        Optional<PendingProduct> pendingProduct = service.updatePendingProductStatus(id, request);
        return new ResponseEntity<Optional<PendingProduct>>(pendingProduct, HttpStatus.OK);
    }

}
