package com.smartphoneshop.repositories;

import com.smartphoneshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ICategoryRepository extends JpaRepository<Category , Integer>, JpaSpecificationExecutor<Category> {

    Category findCategoryById(Integer id);

    Category findCategoryByName(String name);

    boolean existsCategoryByName(String name);
}
