package com.smartphoneshop.services;

import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.entity.ProductRate;
import com.smartphoneshop.forms.CreateProductRateForm;
import com.smartphoneshop.specifications.GenericSpecification;

import java.util.List;

public interface IProductRateService {
    ProductRate findOne(GenericSpecification<ProductRate> specification);

    ProductRate create(CreateProductRateForm createProductRateForm);

    PaginateDTO<ProductRate> getList(Integer page, Integer perPage, GenericSpecification<ProductRate> specification);
}
