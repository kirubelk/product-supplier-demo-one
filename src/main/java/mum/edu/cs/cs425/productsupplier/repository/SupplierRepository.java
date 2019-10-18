package mum.edu.cs.cs425.productsupplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.cs.cs425.productsupplier.models.SupplierProduct;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierProduct, Integer>{

}
    

