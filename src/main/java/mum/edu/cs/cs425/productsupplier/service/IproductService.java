package mum.edu.cs.cs425.productsupplier.service;

import java.util.List;

import mum.edu.cs.cs425.productsupplier.models.Product;

public interface IproductService {
    Product saveProduct(Product pro);
    List<Product> getProducts();
    Product getProduct (long pdNumber);
}