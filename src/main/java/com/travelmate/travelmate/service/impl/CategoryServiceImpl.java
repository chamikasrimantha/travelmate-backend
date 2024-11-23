package com.travelmate.travelmate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelmate.travelmate.entity.CategoryEntity;
import com.travelmate.travelmate.repository.CategoryRepository;
import com.travelmate.travelmate.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity deleteCategory(Long id) {
        CategoryEntity existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory!=null) {
            categoryRepository.delete(existingCategory);
            return existingCategory;
        } else {
            return null;
        }
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoriesById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
        CategoryEntity existingCategory = categoryRepository.findById(id).orElse(null);
        if (existingCategory!=null) {
            existingCategory.setName(categoryEntity.getName());
            return categoryRepository.save(existingCategory);
        } else {
            return null;
        }
    }
    
}
