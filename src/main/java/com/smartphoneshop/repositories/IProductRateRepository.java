package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.ProductRates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRateRepository extends JpaRepository<ProductRates , Integer> {
}
