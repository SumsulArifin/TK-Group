package com.tkgroupbd.pusti.api.services.mastersettings.sales;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.sales.Brand;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.sales.BrandRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface BrandService {
    MessageResponse addBrand(BrandRequest brandRequest);

    Optional<Brand> updateBrand(Integer brandId, BrandRequest brandRequest);

    Optional<Brand> brandStatusChangeAPI(Integer brandId, BrandRequest brandRequest);

    void deleteBrand(Integer brandId);

    Brand getBrandById(Integer brandId);

    List<Brand> getAllBrand();

    List<Brand> findSortedBrandByKey(String field);

    Page<Brand> findBrandByPagination(int offset, int pageSize);

    Page<Brand> findSortedBrandByPagination(int offset, int pageSize, String field);

}
