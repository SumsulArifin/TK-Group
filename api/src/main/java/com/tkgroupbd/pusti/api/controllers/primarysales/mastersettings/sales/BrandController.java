package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Brand;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.BrandRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.sales.BrandServiceImpl;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Brand")
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandServiceImpl brandService;

    // Create a new Brand
    @PostMapping("/addBrand")
    public ResponseEntity<MessageResponse> addBrand(@RequestBody BrandRequest brandRequest) {
        MessageResponse newBrand = brandService.addBrand(brandRequest);
        return new ResponseEntity<>(newBrand, HttpStatus.CREATED);
    }

    // Update a Brand information
    @PutMapping("/updateBrand/{brand_id}")
    public ResponseEntity<Optional<Brand>> updateBrand(@PathVariable Integer brand_id,
            @RequestBody BrandRequest brandRequest) {
        Optional<Brand> updateBrand = brandService.updateBrand(brand_id, brandRequest);
        return new ResponseEntity<Optional<Brand>>(updateBrand, HttpStatus.OK);
    }

    // brand Status Change API
    @PutMapping("/brandStatusChangeAPI/{brand_id}")
    public ResponseEntity<Optional<Brand>> brandStatusChangeAPI(@PathVariable Integer brand_id,
            @RequestBody BrandRequest brandRequest) {
        Optional<Brand> updateBrand = brandService.brandStatusChangeAPI(brand_id, brandRequest);
        return new ResponseEntity<Optional<Brand>>(updateBrand, HttpStatus.OK);
    }

    @GetMapping("/getAllBrand")
    public ResponseEntity<List<Brand>> getAllBrand() {
        List<Brand> brands = brandService.getAllBrand();
        return new ResponseEntity<>(brands, HttpStatus.OK);
    }

    // Delete depot by id
    @DeleteMapping("/deleteBrand/{brand_id}")
    public ResponseEntity<?> deleteBrand(@PathVariable("brand_id") Integer brand_id) {
        brandService.deleteBrand(brand_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Find by id Api
    @GetMapping("/getBrandById/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable("brand_id") Integer brand_id) {
        Brand brand = brandService.getBrandById(brand_id);
        return new ResponseEntity<>(brand, HttpStatus.OK);
    }

    @GetMapping("/getSortedBrandByKey/{field}")
    private ApiResponse<List<Brand>> getSortedBrandByKey(@PathVariable String field) {
        List<Brand> brandList = brandService.findSortedBrandByKey(field);
        return new ApiResponse(brandList.size(), brandList);
    }

    @GetMapping("/getPaginatedBrands/{offset}/{pageSize}")
    private ApiResponse<Page<Brand>> getPaginatedBrands(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Brand> paginatedBrands = brandService.findBrandByPagination(offset, pageSize);
        return new ApiResponse(paginatedBrands.getSize(), paginatedBrands);
    }

    @GetMapping("/getSortedPaginatedBrand/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<Brand>> getSortedPaginatedBrand(@PathVariable int offset,
            @PathVariable int pageSize, @PathVariable String field) {
        Page<Brand> paginatedSortedBrands = brandService.findSortedBrandByPagination(offset, pageSize, field);
        return new ApiResponse(paginatedSortedBrands.getSize(), paginatedSortedBrands);
    }

}
