package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ProductRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRateRepository extends JpaRepository<ProductRate, Integer> {
}
