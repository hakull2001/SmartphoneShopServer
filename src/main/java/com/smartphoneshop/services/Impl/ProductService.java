package com.smartphoneshop.services.Impl;

import com.smartphoneshop.entity.Product;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.ICategoryService;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {


    @Autowired
    private IProductRepository repository;

    @Autowired
    private IProductImageService productImageService;

    @Autowired
    private ICategoryService categoryService;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return repository.findProductById(id);
    }

    @Override
    public Product getProductByTitle(String title) {
        return repository.findProductByTitle(title);
    }

    @Override
    public Product createProduct(CreateProductForm form) {
        Product product = form.toEntity();
        product.setCategory(categoryService.getCategoryById(form.getCateId()));
        repository.save(product);
        product.setProductImages(productImageService.createProductImages(form.getProductImages() , product));
        return product;
    }

    @Override
    public boolean updateProduct(Integer id , UpdateProductForm form) {
        if(!repository.existsProductByTitle(form.getTitle())) {
            Product product = form.toEntity();
            product.setId(id);
            product.setCategory(categoryService.getCategoryById(form.getCateId()));
            product.setCreatedDate(repository.findProductById(id).getCreatedDate());
            repository.save(product);
            product.setProductImages(productImageService.createProductImages(form.getProductImages(), product));
            return true;
        }
        return false;
    }

    @Override
    public void unLockProductStatus(Integer id) {
        Product product = repository.findProductById(id);
        if(product.getStatus() == 0)
            product.setStatus((short) 1);
        repository.save(product);
    }

    @Override
    public void lockProductStatus(Integer id) {
        Product product = repository.findProductById(id);
        if(product.getStatus() == 1)
            product.setStatus((short) 0);
        repository.save(product);


    }


}
