package com.example.virtual.plant.store.repository;

import com.example.virtual.plant.store.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Products,Integer> {
}
