package com.example.virtual.plant.store.repository;

import com.example.virtual.plant.store.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
}
