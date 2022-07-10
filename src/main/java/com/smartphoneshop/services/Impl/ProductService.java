package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
