package com.smartphoneshop.controllers;

import com.smartphoneshop.dto.ProductDTO;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductImage;
import com.smartphoneshop.services.ICategoryService;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService service;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductImageService productImageService;
    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts() , HttpStatus.OK);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable(value = "productId") Integer productId) throws Exception {
        Product product = service.getProductById(productId);
        if(product == null)
            throw new Exception("Not found product");

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    //PRODUCT : TEN, ANH

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody @Valid ProductDTO productDTO) throws Exception {
        Product product = service.create(productDTO);
        for (ProductImage productImage : product.getProductImages()){
            productImage.setProduct(product);
            productImageService.create(productImage);
        }
        return new ResponseEntity<>("CREATE SUCCESSFUL", HttpStatus.CREATED);
    }

}
