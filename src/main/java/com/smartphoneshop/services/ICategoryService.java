package com.smartphoneshop.services;

import com.smartphoneshop.entity.Category;

import java.util.List;


public interface ICategoryService {
   List<Category> getAllCategories();

   Category getCategoryById(Integer categoryId);
}
