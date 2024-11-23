package com.travelmate.travelmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelmate.travelmate.entity.CategoryEntity;
import com.travelmate.travelmate.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/categories")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody CategoryEntity categoryEntity){
        try {
            return ResponseEntity.status(200).body(categoryService.createCategory(categoryEntity));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> getAllCategories(){
        List<CategoryEntity> categoryEntities = categoryService.getAllCategories();
        if (categoryEntities!=null) {
            return ResponseEntity.status(200).body(categoryEntities);
        } else {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryEntity> getCategoriesById(@PathVariable Long id){
        CategoryEntity categoryEntity = categoryService.getCategoriesById(id);
        if (categoryEntity!=null) {
            return ResponseEntity.status(HttpStatus.OK).body(categoryEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/categories/{id}")
    public CategoryEntity updateCategory(@PathVariable Long id, @RequestBody CategoryEntity categoryEntity){
        return categoryService.updateCategory(id, categoryEntity);
    }

    @DeleteMapping("/categories/{id}")
    public CategoryEntity deleteCategory(@PathVariable Long id){
        return categoryService.deleteCategory(id);
    }
    
}
