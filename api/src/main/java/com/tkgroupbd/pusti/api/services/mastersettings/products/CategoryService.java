package com.tkgroupbd.pusti.api.services.mastersettings.products;

import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Category;

import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.CategoryRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CategoryService {

   MessageResponse createCategory(CategoryRequest categoryRequest);

   Optional<Category> updateCategory(Integer id, CategoryRequest CategoryRequest);

    void deleteCategory(Integer id);
    Category getCategoryById(Integer id);

   List<Category> getAllCategory();

    Optional<Category> categoryStatusChange(Integer id, CategoryRequest categoryRequest);







}
