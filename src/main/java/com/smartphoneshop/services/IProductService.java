package com.smartphoneshop.services;

import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.specifications.GenericSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductService{
    List<Product> getAllProducts();

    PaginateDTO<Product> getList(Integer page, Integer perPage, GenericSpecification<Product> specification);

    Product getProductById(Integer id);
}
