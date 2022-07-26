package com.smartphoneshop.controllers;

import com.smartphoneshop.base.BaseController;
import com.smartphoneshop.constants.Common;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.exceptions.NotFoundException;
import com.smartphoneshop.filters.ProductFilter;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import com.smartphoneshop.services.IProductService;
import com.smartphoneshop.specifications.GenericSpecification;
import com.smartphoneshop.specifications.SearchCriteria;
import com.smartphoneshop.specifications.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
public class ProductController extends BaseController<Product> {

    @Autowired
    private IProductService service;

    @GetMapping
    public ResponseEntity<?> getAllProducts(ProductFilter productFilter, HttpServletRequest request){
        GenericSpecification<Product> specification = new GenericSpecification<Product>().getBasicQuery(request);

        if(productFilter.getStartId() != null)
            specification.add(new SearchCriteria("id", productFilter.getStartId(), SearchOperation.GREATER_THAN_EQUAL));
        if(productFilter.getEndId() != null)
            specification.add(new SearchCriteria("id", productFilter.getEndId(), SearchOperation.LESS_THAN_EQUAL));
        if(productFilter.getSearch() != null)
            specification.add(new SearchCriteria("title", productFilter.getSearch(), SearchOperation.LIKE));

        if(productFilter.getMnOPrice() != null)
            specification.add(new SearchCriteria("originalPrice", productFilter.getMnOPrice(), SearchOperation.GREATER_THAN_EQUAL));

        if(productFilter.getMxOPrice() != null)
            specification.add(new SearchCriteria("originalPrice", productFilter.getMxOPrice(), SearchOperation.LESS_THAN_EQUAL));


        PaginateDTO<Product> paginateProducts = service.getAllProducts(productFilter.getPage(), productFilter.getPerPage(), specification);
        return this.resPagination(paginateProducts);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id){
        Product product  = service.getProductById(id);
        if(product == null)
            throw new NotFoundException(Common.MSG_NOT_FOUND);
        return this.resSuccess(product);
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<?> getProductByTitle(@PathVariable("title") String title){
        Product product  = service.getProductByTitle(title);
        if(product == null)
            throw new NotFoundException(Common.MSG_NOT_FOUND);
        return this.resSuccess(product);
    }

    @PostMapping
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> createProduct(@RequestBody CreateProductForm form){
        return new ResponseEntity<>(service.createProduct(form),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id , @RequestBody UpdateProductForm form){
        service.updateProduct(id,form);
        return new ResponseEntity<>("updated Successful",HttpStatus.OK);
    }


    @PutMapping(value = "/unlock/{id}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> unLockProduct(@PathVariable("id") Integer id){
        service.unLockProductStatus(id);
        return new ResponseEntity<>("Unlock Product Successfull",HttpStatus.OK);
    }

    @PutMapping(value = "/lock/{id}")
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    public ResponseEntity<?> lockProduct(@PathVariable("id") Integer id){
        service.lockProductStatus(id);
        return new ResponseEntity<>("Lock Product Successfull",HttpStatus.OK);
    }





}
