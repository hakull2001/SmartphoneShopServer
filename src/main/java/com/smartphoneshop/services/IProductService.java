package com.smartphoneshop.services;

import com.smartphoneshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductService{
    List<Product> getAllProducts();
}
