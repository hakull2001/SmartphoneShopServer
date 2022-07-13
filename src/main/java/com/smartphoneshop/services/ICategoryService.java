package com.smartphoneshop.services;

import com.smartphoneshop.entity.Category;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(Integer id);

    List<Category> getAllCategory();
}
