package com.smartphoneshop.services;

import com.smartphoneshop.entity.ProductRates;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductRateService {
    List<ProductRates> getListProductRates(Integer productId);
}
