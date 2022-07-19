package com.smartphoneshop.services.Impl;

import com.smartphoneshop.constants.StatusCodeEnum;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.forms.CreateCategoryForm;
import com.smartphoneshop.forms.UpdateCategoryForm;
import com.smartphoneshop.repositories.ICategoryRepository;
import com.smartphoneshop.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository repository;

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Category getCategoryByName(String name) {
        return repository.findCategoryByName(name);
    }

    @Override
    public Category createCategory(CreateCategoryForm form) throws Exception {

            if(!repository.existsCategoryByName(form.getName()))
            {
                Category category1= new Category();
                category1.setName(form.getName());
                return repository.save(category1);
            }else
                throw new Exception("Error Exists Category");
    }

    @Override
    public boolean UpdateCategory(Integer id, UpdateCategoryForm form) {
        if(!repository.existsCategoryByName(form.getName())){
            Category category =repository.findCategoryById(id);
            category.setName(form.getName());
            repository.save(category);
            return true;
        }
        return  false;
    }

    @Override
    public void unLockCategoryStatus(Integer id) throws Exception {
        Category category = repository.findCategoryById(id);
        if(category.getStatus()== StatusCodeEnum.NOT_ACTIVE)
        {
            category.setStatus(StatusCodeEnum.ACTIVE);
            repository.save(category);
        }
        else
            throw new Exception("Category is ACTIVE");


    }

    @Override
    public void lockCategory(Integer id) throws Exception {
        Category category = repository.findCategoryById(id);
        if(category.getStatus()==StatusCodeEnum.ACTIVE){
            category.setStatus(StatusCodeEnum.NOT_ACTIVE);
            repository.save(category);
        }
        else
            throw new Exception("Category is NO_ACTIVE");
    }


    @Override
    public Category getCategoryById(Integer id) {
        return repository.findCategoryById(id);
    }



}
