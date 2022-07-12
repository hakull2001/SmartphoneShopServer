package com.smartphoneshop.services;

import com.smartphoneshop.entity.ProductImage;

public interface IProductImageService {
    ProductImage findByImageUrl(String imageUrl);

    ProductImage create(ProductImage productImage);


}
