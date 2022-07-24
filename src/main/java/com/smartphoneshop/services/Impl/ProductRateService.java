package com.smartphoneshop.services.Impl;

import com.smartphoneshop.base.BasePagination;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductRate;
import com.smartphoneshop.entity.User;
import com.smartphoneshop.forms.CreateProductRateForm;
import com.smartphoneshop.repositories.IProductRateRepository;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.repositories.IUserRepository;
import com.smartphoneshop.services.IProductRateService;
import com.smartphoneshop.specifications.GenericSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRateService extends BasePagination<ProductRate, IProductRateRepository> implements IProductRateService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductRateRepository productRateRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    public ProductRateService(IProductRateRepository productRateRepository){
        super(productRateRepository);
    }
    @Override
    public ProductRate findOne(GenericSpecification<ProductRate> specification) {
        return productRateRepository.findOne(specification).orElse(null);
    }

    @Override
    public ProductRate create(CreateProductRateForm createProductRateForm) {
        Product product = productRepository.findById(createProductRateForm.getProductId()).orElse(null);
        User user = userRepository.findById(createProductRateForm.getUserId()).orElse(null);

        ProductRate review = modelMapper.map(createProductRateForm, ProductRate.class);
        review.setProduct(product);
        review.setUser(user);

        return productRateRepository.save(review);
    }

    @Override
    public PaginateDTO<ProductRate> getList(Integer page, Integer perPage, GenericSpecification<ProductRate> specification) {
        return this.paginate(page, perPage, specification);
    }
}
