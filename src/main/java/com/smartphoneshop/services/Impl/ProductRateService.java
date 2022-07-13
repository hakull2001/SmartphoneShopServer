package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.ProductRate;
import com.smartphoneshop.repositories.IProductRateRepository;
import com.smartphoneshop.services.IProductRateService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRateService implements IProductRateService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductRateRepository productRateRepository;


    @Override
    public List<ProductRate> findListProductRatesByProductId(Integer productId) {
        return productRateRepository.findByProductId(productId);
    }
}
