package com.smartphoneshop.services;

import com.smartphoneshop.entity.ProductRate;

import java.util.List;

public interface IProductRateService {
    List<ProductRate> findListProductRatesByProductId(Integer productId);
}
