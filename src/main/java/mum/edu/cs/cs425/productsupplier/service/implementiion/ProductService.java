package mum.edu.cs.cs425.productsupplier.service.implementiion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.cs.cs425.productsupplier.models.Product;
import mum.edu.cs.cs425.productsupplier.repository.ProductRepository;
import mum.edu.cs.cs425.productsupplier.service.IproductService;

@Service
public class ProductService implements IproductService {

    @Autowired
    private ProductRepository productRepol;
    

    @Override
    public Product saveProduct(Product pro) {
        return productRepol.save(pro);
    }

    @Override
    public List<Product> getProducts() {
        return productRepol.findAll();
    }

    @Override
    public Product getProduct(long pdNumber) {
        return productRepol.findById(pdNumber).orElse(null);
    }
    
}