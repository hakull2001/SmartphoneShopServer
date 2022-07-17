package com.smartphoneshop.controllers;

import com.smartphoneshop.base.BaseController;
import com.smartphoneshop.constants.StatusCodeProductEnum;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.User;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import com.smartphoneshop.services.ICategoryService;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import com.smartphoneshop.specifications.FilterSearch;
import com.smartphoneshop.specifications.GenericSpecification;
import com.smartphoneshop.specifications.SearchCriteria;
import com.smartphoneshop.specifications.SearchOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
@Validated
public class ProductController extends BaseController<Product> {

    @Autowired
    private IProductService service;


    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllProducts(FilterSearch filterSearch ,
                                            @RequestParam(required = false , value = "search") String search,
                                            HttpServletRequest request){
        GenericSpecification<Product> specification = new GenericSpecification<Product>().getBasicQuery(request);
        if(filterSearch.getMnId() != null)
            specification.add(new SearchCriteria("id" , filterSearch.getMnId() , SearchOperation.GREATER_THAN_EQUAL));
        if(filterSearch.getMxId() != null){
            specification.add(new SearchCriteria("id" , filterSearch.getMxId() , SearchOperation.LESS_THAN_EQUAL));
        }
        if(!search.isEmpty() && !search.isBlank()){
            specification.add(new SearchCriteria("title" , search , SearchOperation.LIKE));
        }
        PaginateDTO<Product> paginateProducts = service.getAllProducts(filterSearch.getPage(),
                                                    filterSearch.getSize(), specification);
        return this.resPagination(paginateProducts);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id){
        Product product  = service.getProductById(id);
        return new ResponseEntity<>(product , HttpStatus.OK);
    }

    @GetMapping(value = "/title/{title}")
    public ResponseEntity<?> getProductByTitle(@PathVariable("title") String title){
        Product product  = service.getProductByTitle(title);
        return new ResponseEntity<>(product , HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid CreateProductForm form){
        return new ResponseEntity<>(service.createProduct(form),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id , @RequestBody @Valid UpdateProductForm form){
        service.updateProduct(id,form);
        return new ResponseEntity<>("updated Successful",HttpStatus.OK);
    }


    @PutMapping(value = "/unlock/{id}")
    public ResponseEntity<?> unLockProduct(@PathVariable("id") Integer id){
        service.unLockProductStatus(id);
        return new ResponseEntity<>("Unlock Product Successfull",HttpStatus.OK);
    }

    @PutMapping(value = "/lock/{id}")
    public ResponseEntity<?> lockProduct(@PathVariable("id") Integer id){
        service.lockProductStatus(id);
        return new ResponseEntity<>("Lock Product Successfull",HttpStatus.OK);
    }





}
