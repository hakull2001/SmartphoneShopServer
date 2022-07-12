package com.smartphoneshop.services;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductImage;
import com.smartphoneshop.forms.CreateProductImageForm;

import java.util.List;


public interface IProductImageService {

    List<ProductImage> createProductImages(List<CreateProductImageForm> images , Product productId);

}
