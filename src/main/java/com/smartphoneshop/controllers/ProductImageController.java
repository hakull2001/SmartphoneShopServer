package com.smartphoneshop.controllers;

import com.smartphoneshop.base.BaseController;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductImage;
import com.smartphoneshop.exceptions.AppException;
import com.smartphoneshop.exceptions.NotFoundException;
import com.smartphoneshop.helpers.FileHelper;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-images")
public class ProductImageController extends BaseController<ProductImage> {
    @Autowired
    private IProductImageService productImageService;

    @Autowired
    private IProductService productService;


    @PostMapping
    @PreAuthorize("@userAuthorizer.isAdmin(authentication)")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> createOrUpdateProductImages(@RequestParam("productId") Integer productId,
                                                         @RequestParam("files") MultipartFile[] files) {

        for (MultipartFile file : files) {
            if (!FileHelper.isAllowImageType(file.getOriginalFilename())) {
                throw new AppException("This file type is not allowed");
            }
        }

        Product product = productService.getProductById(productId);

        if (product == null) {
            throw new NotFoundException("Not found product");
        }

        List<ProductImage> productImages = productImageService.createOrUpdateMany(product, files);

        return this.resListSuccess(productImages);
    }
}
