package com.smartphoneshop.services.Impl;

import com.smartphoneshop.base.BasePagination;
import com.smartphoneshop.constants.StatusCodeProductEnum;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.forms.CreateProductForm;
import com.smartphoneshop.forms.UpdateProductForm;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.ICategoryService;
import com.smartphoneshop.services.IProductImageService;
import com.smartphoneshop.services.IProductService;
import com.smartphoneshop.specifications.GenericSpecification;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BasePagination<Product, IProductRepository> implements IProductService {


    @Autowired
    private IProductRepository repository;

    @Autowired
    private IProductImageService productImageService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    public ProductService(IProductRepository iProductRepository){
        super(iProductRepository);
    }


    @Override
    public PaginateDTO<Product> getAllProducts(Integer page, Integer perPage, GenericSpecification<Product> specification) {


        return this.paginate(page, perPage, specification);
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
        product.setCategory(categoryService.getCategoryById(form.getCategoryId()));
        return repository.save(product);
    }

    @Override
    public void updateProduct(Integer id , UpdateProductForm form) {

            Product product = form.toEntity();
            product.setId(id);
            product.setCategory(categoryService.getCategoryById(form.getCategoryId()));
            product.setCreatedDate(repository.findProductById(id).getCreatedDate());
            repository.save(product);
            product.setProductImages(productImageService.createProductImages(form.getProductImages(), product));

    }

    @Override
    public void updateProductAmount(Product product, Integer amount) {
        product.setAmount(amount);
        repository.save(product);
    }


    @Override
    public void unLockProductStatus(Integer id) {
        Product product = repository.findProductById(id);
        if(product.getStatus() == StatusCodeProductEnum.CLOSED)
            product.setStatus(StatusCodeProductEnum.OPENING);
        repository.save(product);
    }

    @Override
    public void lockProductStatus(Integer id) {
        Product product = repository.findProductById(id);
        if(product.getStatus() == StatusCodeProductEnum.OPENING)
            product.setStatus(StatusCodeProductEnum.CLOSED);
        repository.save(product);


    }

    @Override
    public boolean existsProductByTitle(String title) {
        return repository.existsProductByTitle(title);
    }


}
