package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImagesRepository extends JpaRepository<ProductImage , Integer> {
}
