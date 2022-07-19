package com.smartphoneshop.controllers;

import com.smartphoneshop.constants.StatusCodeEnum;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.forms.CreateCategoryForm;
import com.smartphoneshop.forms.UpdateCategoryForm;
import com.smartphoneshop.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategories(Pageable pageable){
        Page<Category> categories = iCategoryService.getAllCategory(pageable);
        List<Category> categories1= new ArrayList<>();
        for (Category categorie:categories) {
            if(categorie.getStatus()== StatusCodeEnum.ACTIVE)
                categories1.add(categorie);
        }
        Page<Category> cate = new PageImpl<>(categories1,pageable,categories.getTotalElements());
        return  new ResponseEntity<>(cate,HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "categoryId") Integer categoryId) throws Exception {
        Category category = iCategoryService.getCategoryById(categoryId);
        if(category==null)
            throw new Exception("Not found category");
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<?> getCategoryByName(@PathVariable("name") String name) throws Exception {
        Category category = iCategoryService.getCategoryByName(name);
        if(category==null)
            throw new Exception("Not found category you find");
        return new ResponseEntity<>(category,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNewCategory(@RequestBody CreateCategoryForm form, Category category) throws Exception {
        return new ResponseEntity<>(iCategoryService.createCategory(form),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") Integer id, @RequestBody UpdateCategoryForm form){
        if(iCategoryService.UpdateCategory(id,form))
            return new ResponseEntity<>("Update successfuly!",HttpStatus.OK);
        return  new ResponseEntity<>("ERROR UPDATE CHECK AGAIN INFO ",HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "unlock/{id}")
    public ResponseEntity<?> unLockCategory(@PathVariable("id") Integer id) throws Exception {
        if(unLockCategory(id)!=null)
        {
            iCategoryService.unLockCategoryStatus((id));
            return new ResponseEntity<>("Unlock Category Successful",HttpStatus.OK);
        }
        throw new Exception("NOT FOUND CATEGORY UNLOCK");
    }

    @PutMapping(value = "lock/{id}")
    public ResponseEntity<?> lockCategory(@PathVariable("id") Integer id) throws Exception {
        if(lockCategory(id)!= null)
        {
            iCategoryService.lockCategory(id);
            return new ResponseEntity<>("Lock successful",HttpStatus.OK);
        }
        throw new Exception("NOT FOUND CATEGORY LOCK");
    }

}
