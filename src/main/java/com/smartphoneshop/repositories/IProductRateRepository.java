package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ProductRates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRateRepository extends JpaRepository<ProductRates , Integer> {
    List<ProductRates> findByProductId(Integer productId);
}
