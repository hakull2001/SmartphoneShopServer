package com.smartphoneshop.services;

import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import com.smartphoneshop.specifications.GenericSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductService{


    public PaginateDTO<Product> getAllProducts(Integer page, Integer perPage, GenericSpecification<Product> specification);

    public Product getProductById(Integer id);

    public Product getProductByTitle(String title);

    Product createProduct(CreateProductForm form);

    boolean updateProduct(Integer id, UpdateProductForm form);

    void unLockProductStatus(Integer id);

    void lockProductStatus(Integer id);
}
