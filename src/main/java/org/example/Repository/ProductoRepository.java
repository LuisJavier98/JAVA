package org.example.Repository;

import org.example.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Product,Integer> {

   Optional<Product> findByName(String name);
}