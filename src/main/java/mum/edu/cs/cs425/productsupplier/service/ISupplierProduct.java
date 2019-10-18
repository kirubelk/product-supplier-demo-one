package mum.edu.cs.cs425.productsupplier.service;

import java.util.List;

import mum.edu.cs.cs425.productsupplier.models.SupplierProduct;

public interface ISupplierProduct {

    SupplierProduct saveSupplier(SupplierProduct sp);
    List<SupplierProduct> getSupplierProductList ();
    SupplierProduct getSupplier(Integer id);
    void deleteSupplier(Integer id);
}