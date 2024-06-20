package com.travelmate.travelmate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.CategoryEntity;

@Service
public interface CategoryService {
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategoriesById(Long id);
    CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity);
    CategoryEntity deleteCategory(Long id);
}
