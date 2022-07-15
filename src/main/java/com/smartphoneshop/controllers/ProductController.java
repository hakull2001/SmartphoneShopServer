package com.smartphoneshop.controllers;

import com.smartphoneshop.constants.StatusCodeProductEnum;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import com.smartphoneshop.services.ICategoryService;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
@Validated
public class ProductController {

    @Autowired
    private IProductService service;


//    @Autowired
//    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getAllProducts(Pageable pageable){
        Page<Product> products = service.getAllProducts(pageable);
        List<Product> products1 = new ArrayList<>();
        for (Product product:products) {
            if(product.getStatus() == StatusCodeProductEnum.OPENING)
                products1.add(product);
        }
        Page<Product> prod = new PageImpl<>(products1 , pageable , products.getTotalElements());
        return new ResponseEntity<>(prod , HttpStatus.OK);
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
