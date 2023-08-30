package com.tkgroupbd.pusti.api.controllers.primarysales.mastersettings.products;
import com.tkgroupbd.pusti.api.data.models.entity.mastersettings.products.Category;
import com.tkgroupbd.pusti.api.data.payloads.requests.mastersettings.products.CategoryRequest;
import com.tkgroupbd.pusti.api.data.payloads.response.MessageResponse;
import com.tkgroupbd.pusti.api.services.mastersettings.products.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Category")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categories = categoryService.getAllCategory();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addCategory(@RequestBody CategoryRequest categoryRequest) {
        MessageResponse newCategory = categoryService.createCategory(categoryRequest);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteBy/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<Optional<Category>> updateCategory(@PathVariable Integer id,
            @RequestBody CategoryRequest categoryRequest) {
        Optional<Category> updateCategory = categoryService.updateCategory(id, categoryRequest);
        return new ResponseEntity<Optional<Category>>(updateCategory, HttpStatus.OK);
    }

    @PutMapping("/updateCategoryStatus/{id}")
    public ResponseEntity<Optional<Category>> updateCategoryStatus(@PathVariable Integer id,
            @RequestBody CategoryRequest categoryRequest) {
        Optional<Category> updateCategory = categoryService.categoryStatusChange(id, categoryRequest);
        return new ResponseEntity<Optional<Category>>(updateCategory, HttpStatus.OK);
    }

}
