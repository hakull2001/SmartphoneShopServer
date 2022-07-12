package com.smartphoneshop.services;
import com.smartphoneshop.dto.ProductDTO;
import com.smartphoneshop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {
     List<Product> getAllProducts();

     Product getProductById(Integer productId);

     Product create(ProductDTO productDTO);
}
