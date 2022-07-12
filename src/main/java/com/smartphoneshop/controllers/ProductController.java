package com.smartphoneshop.controllers;

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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
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
            if(product.getStatus() == 1)
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
    public ResponseEntity<?> createProduct(@RequestBody CreateProductForm form){
        return new ResponseEntity<>(service.createProduct(form),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id , @RequestBody UpdateProductForm form){
        if(service.updateProduct(id,form))
            return new ResponseEntity<>("updated Successful",HttpStatus.OK);
        return new ResponseEntity<>("Something wrent wrong",HttpStatus.BAD_REQUEST);
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
