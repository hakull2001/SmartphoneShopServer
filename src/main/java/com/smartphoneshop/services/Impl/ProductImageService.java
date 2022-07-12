package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductImage;
import com.smartphoneshop.forms.CreateProductImageForm;
import com.smartphoneshop.repositories.IProductImagesRepository;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.IProductImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageService implements IProductImageService {

    @Autowired
    private IProductImagesRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<ProductImage> createProductImages(List<CreateProductImageForm> images , Product product) {
        List<ProductImage> productImages = new ArrayList<>();
        for (CreateProductImageForm img:images) {
            ProductImage image = img.toEntity();
            image.setProduct(product);
            productImages.add(image);
            repository.save(image);
        }
        return productImages;
    }
}
