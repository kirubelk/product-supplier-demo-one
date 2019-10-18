package mum.edu.cs.cs425.productsupplier.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Table(name = "product_info")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "* Product Number is required")
    @Column(name = "product_number")
    private Long productNumber;

    @NotBlank
    @Column(name = "product_name")
    private String name;

    @NotNull(message = "* Unit Price is required")
    @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format as 'xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    @Column(name = "unit_price")
    private Double unitPrice;


    @NotNull(message = "* Quantity in stock is required")
    @Digits(integer = 9, fraction = 0, message = "* Quantity must be a positive, integral value")
    @Column(name = "quantity_inStock")
    private Integer quantityInStock;

    @NotNull(message = "* Date supplied is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name ="date_supplied")
    private LocalDate dateSupplied;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = true)
    private SupplierProduct supplier;
    


    public Product(){

    }

    public Product(Long productNumber, String name, Double unitPrice, LocalDate dateSupplied){
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.dateSupplied = dateSupplied;
    }

    public Product(Long productNumber, String name, Double unitPrice, LocalDate dateSupplied, SupplierProduct suppler){
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.dateSupplied = dateSupplied;
        this.supplier = suppler;

    }
    
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return Long return the productNumber
     */
    public Long getProductNumber() {
        return productNumber;
    }

    /**
     * @param productNumber the productNumber to set
     */
    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Double return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    
    /**
     * @return LocalDate return the dateSupplied
     */
    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    /**
     * @param dateSupplied the dateSupplied to set
     */
    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }


    /**
     * @return Supplier return the supplier
     */
    public SupplierProduct getSupplier() {
        return supplier;
    }

    /**
     * @param supplier the supplier to set
     */
    public void setSupplier(SupplierProduct supplier) {
        this.supplier = supplier;
    }


    /**
     * @return Integer return the quantityInStock
     */
    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    /**
     * @param quantityInStock the quantityInStock to set
     */
    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

}