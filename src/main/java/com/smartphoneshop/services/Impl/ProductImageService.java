package com.smartphoneshop.services.Impl;

import com.smartphoneshop.constants.Common;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductImage;
import com.smartphoneshop.forms.CreateProductImageForm;
import com.smartphoneshop.helpers.FileHelper;
import com.smartphoneshop.repositories.IProductImagesRepository;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageService implements IProductImageService {

    @Autowired
    private IProductImagesRepository repository;

    @Autowired
    private IStorageService storageService;

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

    @Override
    public void deleteByProductId(Integer productId) {
        repository.deleteByProductId(productId);
    }

    @Override
    public List<ProductImage> createOrUpdateMany(Product product, MultipartFile[] files) {
        this.deleteByProductId(product.getId());
        storageService.deleteFilesByPrefix(String.valueOf(product.getId()), Common.PRODUCT_IMAGE_UPLOAD_PATH);
        List<ProductImage> productImages = new ArrayList<>();
        for (MultipartFile file : files) {
            String randomUniqueFileName = FileHelper.randomUniqueFileName(product.getId() + "-" + file.getOriginalFilename());
            String imageUrl = storageService.store(
                    Common.PRODUCT_IMAGE_UPLOAD_PATH,
                    file,
                    randomUniqueFileName
            );
            ProductImage productImage = new ProductImage(null, imageUrl, randomUniqueFileName, product, null, null);
            ProductImage newProductImage = repository.save(productImage);
            productImages.add(newProductImage);
        }
        return productImages;
    }
}
