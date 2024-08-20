package com.cotuca.repositores;

import com.cotuca.models.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<ProductCategory, Integer> {}