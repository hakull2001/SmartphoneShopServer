package com.smartphoneshop.services.Impl;

import com.smartphoneshop.dto.ProductDTO;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.repositories.ICategoryRepository;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductRepository repository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Integer productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product newProduct = modelMapper.map(productDTO, Product.class);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
        newProduct.setCategory(category);
        return repository.save(newProduct);
    }
}
