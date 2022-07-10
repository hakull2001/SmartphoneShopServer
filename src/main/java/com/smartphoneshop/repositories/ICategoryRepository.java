package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
