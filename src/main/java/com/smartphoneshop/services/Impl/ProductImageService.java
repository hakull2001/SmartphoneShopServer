package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.ProductImage;
import com.smartphoneshop.repositories.IProductImagesRepository;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImageService implements IProductImageService {

    @Autowired
    private IProductImagesRepository productImagesRepository;

    @Override
    public ProductImage findByImageUrl(String imageUrl) {
        return productImagesRepository.findByImageUrl(imageUrl);
    }

    @Override
    public ProductImage create(ProductImage productImage) {
        return productImagesRepository.save(productImage);
    }
}
