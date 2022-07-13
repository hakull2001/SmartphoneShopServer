package com.smartphoneshop.services.Impl;

import com.smartphoneshop.base.BasePagination;
import com.smartphoneshop.dto.ProductDTO;
import com.smartphoneshop.dto.pagination.PaginateDTO;
import com.smartphoneshop.entity.Category;
import com.smartphoneshop.entity.Product;
import com.smartphoneshop.repositories.ICategoryRepository;
import com.smartphoneshop.repositories.IProductRepository;
import com.smartphoneshop.services.IProductService;
import com.smartphoneshop.specifications.GenericSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ProductService extends BasePagination<Product, IProductRepository> implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ProductService(IProductRepository iProductRepository){
        super(iProductRepository);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public PaginateDTO<Product> getList(Integer page, Integer perPage, GenericSpecification<Product> specification) {
        return this.paginate(page, perPage, specification);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product newProduct = modelMapper.map(productDTO, Product.class);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
        newProduct.setCategory(category);
        return productRepository.save(newProduct);
    }
}
