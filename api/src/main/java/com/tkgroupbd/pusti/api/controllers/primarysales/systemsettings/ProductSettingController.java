package com.tkgroupbd.pusti.api.controllers.primarysales.systemsettings;

import com.tkgroupbd.pusti.api.data.models.entity.systemsettings.ProductSettings;
import com.tkgroupbd.pusti.api.data.payloads.requests.systemsettings.ProductSettingRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.systemsettings.ProductSettingServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Product Settings")
@RestController
@RequestMapping("/productSetting")
public class ProductSettingController {
    @Autowired
    private ProductSettingServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> productSettingSave(@RequestBody ProductSettingRequest request) {
        MessageResponse newProductSetting = service.saveProductSetting(request);
        return new ResponseEntity<>(newProductSetting, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProductSettings>> getAllProductSetting() {
        List<ProductSettings> productSetting = service.getAllProductSetting();
        return new ResponseEntity<>(productSetting, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{productSettingId}")
    public ResponseEntity<?> deleteProductSetting(@PathVariable("productSettingId") Integer productSettingId) {
        service.deleteProductSettingById(productSettingId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{productSettingId}")
    public ResponseEntity<ProductSettings> getProductSettingById(
            @PathVariable("productSettingId") Integer productSettingId) {
        ProductSettings productSetting = service.findProductSettingById(productSettingId);
        return new ResponseEntity<>(productSetting, HttpStatus.OK);
    }

    @PutMapping("/update/{productSettingId}")
    public ResponseEntity<Optional<ProductSettings>> updateProductSetting(
            @PathVariable("productSettingId") Integer productSettingId, @RequestBody ProductSettingRequest request) {
        Optional<ProductSettings> productSetting = service.updateProductSetting(productSettingId, request);
        return new ResponseEntity<Optional<ProductSettings>>(productSetting, HttpStatus.OK);
    }

    @PutMapping("/statusChange/{productSettingId}")
    public ResponseEntity<Optional<ProductSettings>> updateProductSettingStatus(
            @PathVariable("productSettingId") Integer productSettingId, @RequestBody ProductSettingRequest request) {
        Optional<ProductSettings> productSetting = service.updateProductSettingStatus(productSettingId, request);
        return new ResponseEntity<Optional<ProductSettings>>(productSetting, HttpStatus.OK);
    }

}
