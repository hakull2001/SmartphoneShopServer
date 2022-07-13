package com.smartphoneshop.controllers;

import com.smartphoneshop.entity.Category;
import com.smartphoneshop.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategories(){
        return  new ResponseEntity<>(iCategoryService.getAllCategory(),HttpStatus.OK);
    }

    @GetMapping("{categoryId}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "categoryId") Integer categoryId) throws Exception {
        Category category = iCategoryService.getCategoryById(categoryId);
        if(category==null)
            throw new Exception("Not found category");
        return new ResponseEntity<>(category,HttpStatus.OK);

    }

}
