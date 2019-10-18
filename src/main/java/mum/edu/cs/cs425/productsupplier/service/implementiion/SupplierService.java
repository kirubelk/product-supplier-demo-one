package mum.edu.cs.cs425.productsupplier.service.implementiion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.cs.cs425.productsupplier.models.SupplierProduct;
import mum.edu.cs.cs425.productsupplier.repository.SupplierRepository;
import mum.edu.cs.cs425.productsupplier.service.ISupplierProduct;

@Service
@Transactional
public class SupplierService implements ISupplierProduct {

    @Autowired
    private SupplierRepository supplierRepo;


    @Override
    public SupplierProduct saveSupplier(SupplierProduct sp) {
        return supplierRepo.save(sp);
    }

    @Override
    public List<SupplierProduct> getSupplierProductList() {
        return supplierRepo.findAll();
    }

    @Override
    public SupplierProduct getSupplier(Integer id) {
        return supplierRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteSupplier(Integer id) {
       supplierRepo.deleteById(id);

    }
    
}