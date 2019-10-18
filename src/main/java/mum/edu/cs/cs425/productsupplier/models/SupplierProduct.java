package mum.edu.cs.cs425.productsupplier.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "supplier_info")
public class SupplierProduct {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Integer supplierId;

    @NotNull(message = "* Supplier Number is required")
    @Digits(integer = 9, fraction = 0, message = "* Supplier number must be numeric; and a positive, integral value")
    @Column(name = "supplier_number")
    private Integer supplierNumber;

    @NotBlank(message = "* Supplier Name is required")
    @Column(name = "supplier_name")
    private String supplierName;

    @NotBlank
    @Column(name = "phone_number")
    private String phoneNumber;



    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();


    public SupplierProduct(){

    }
    public SupplierProduct(int supplierNumber,String supplierName, String phoneNumber){
        this.supplierName = supplierName;
        this.supplierNumber = supplierNumber;
        this.phoneNumber = phoneNumber;
    }

    public SupplierProduct(int supplierNumber,String supplierName, String phoneNumber,  List<Product> products ){

        this.supplierName = supplierName;
        this.supplierNumber = supplierNumber;
        this.phoneNumber = phoneNumber;
        this.products = products;

    }

    /**
     * @return Integer return the supplierId
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * @return int return the supplierNumber
     */
    public Integer getSupplierNumber() {
        return supplierNumber;
    }

    /**
     * @param supplierNumber the supplierNumber to set
     */
    public void setSupplierNumber(Integer supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    /**
     * @return String return the supplierName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param supplierName the supplierName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    /**
     * @return String return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * @return List<Product> return the product
     */
    public List<Product> getProduct() {
        return products;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(List<Product> product) {
        this.products = product;
    }

}