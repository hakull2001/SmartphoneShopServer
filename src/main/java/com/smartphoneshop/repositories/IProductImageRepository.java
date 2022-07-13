package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImageRepository extends JpaRepository<ProductImage, Integer> {
}
