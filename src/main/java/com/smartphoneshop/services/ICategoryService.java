package com.smartphoneshop.services;

import com.smartphoneshop.entity.Category;
import com.smartphoneshop.forms.CreateCategoryForm;
import com.smartphoneshop.forms.UpdateCategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    Category getCategoryById(Integer id);
    Page<Category> getAllCategory(Pageable pageable);

    Category getCategoryByName(String name);

    Category createCategory(CreateCategoryForm form) throws Exception;

    boolean UpdateCategory(Integer id, UpdateCategoryForm form);

    void unLockCategoryStatus(Integer id) throws Exception;

    void lockCategory(Integer id) throws Exception;
}
