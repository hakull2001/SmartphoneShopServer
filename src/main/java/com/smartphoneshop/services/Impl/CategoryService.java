package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Category;
import com.smartphoneshop.repositories.ICategoryRepository;
import com.smartphoneshop.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public Category getCategoryById(Integer id) {
        return repository.findCategoryById(id);
    }
}
