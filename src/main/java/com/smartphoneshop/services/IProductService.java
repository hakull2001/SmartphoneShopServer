package com.smartphoneshop.services;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    public Page<Product> getAllProducts(Pageable pageable);

    public Product getProductById(Integer id);

    public Product getProductByTitle(String title);

    Product createProduct(CreateProductForm form);

    boolean updateProduct(Integer id, UpdateProductForm form);

    void unLockProductStatus(Integer id);

    void lockProductStatus(Integer id);
}
