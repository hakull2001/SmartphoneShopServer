package com.smartphoneshop.controllers;

import com.smartphoneshop.base.BaseController;
import com.smartphoneshop.dto.create.CreateCategoryDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.dto.update.UpdateCategoryDTO;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.services.ICategoryService;
import com.smartphoneshop.specifications.GenericSpecification;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/categories")
@CrossOrigin("*")
public class CategoryController extends BaseController<Category> {
    @Autowired
    private ICategoryService categoryService;


    @GetMapping
    public ResponseEntity<?> getList(@RequestParam(name = "page",required = false) Integer page,
                                     @RequestParam(name = "perPage", required = false) Integer perPage,
                                     HttpServletRequest request){
        GenericSpecification<Category> specification = new GenericSpecification<Category>().getBasicQuery(request);
        PaginateDTO<Category> paginateCategories = categoryService.getList(page, perPage, specification);

        return this.resPagination(paginateCategories);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<?> getById(@PathVariable(name = "categoryId") Integer categoryId,
                                     HttpServletRequest request) throws Exception {
        Category category = categoryService.getCategoryById(categoryId);
        if(category == null)
            throw new Exception("Not found this category");
        return this.resSuccess(category);
    }

    @PostMapping
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> create(@RequestBody @Valid CreateCategoryDTO categoryDTO) throws Exception {
        categoryService.create(categoryDTO);
        return new ResponseEntity<>("Create successful", HttpStatus.CREATED);
    }

    @PatchMapping("/{categoryId}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> update(@RequestBody @Valid UpdateCategoryDTO categoryDTO,
                                    @PathVariable(name = "categoryId") Integer categoryId) throws Exception {
        Category category = categoryService.getCategoryById(categoryId);

        if(category == null)
            throw new Exception("Not found category");
        Category updateCategory = categoryService.update(categoryDTO, category);
        return this.resSuccess(updateCategory);
    }

    @DeleteMapping("/{categoryId}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> delete(@PathVariable(name = "categoryId") Integer categoryId) throws Exception {
        categoryService.deleteById(categoryId);
        return new ResponseEntity<>("Delete successful", HttpStatus.OK);
    }
}
