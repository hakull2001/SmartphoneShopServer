package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product , Integer> {
}
