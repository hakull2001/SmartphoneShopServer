package com.smartphoneshop.services;

import com.smartphoneshop.dto.create.CreateCategoryDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.dto.update.UpdateCategoryDTO;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.specifications.GenericSpecification;

public interface ICategoryService {
    PaginateDTO<Category> getList(Integer page, Integer perPage, GenericSpecification<Category> specification);
    Category getCategoryById(Integer id);
    Category create(CreateCategoryDTO categoryDTO) throws Exception;

    Category update(UpdateCategoryDTO categoryDTO, Category currentCategory) throws Exception;

    void deleteById(Integer categoryId) throws Exception;
}
