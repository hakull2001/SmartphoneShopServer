package com.smartphoneshop.services;

import com.smartphoneshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    public List<Product> getAllProducts();

}
