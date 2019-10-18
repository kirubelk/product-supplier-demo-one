package mum.edu.cs.cs425.productsupplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.cs.cs425.productsupplier.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
}