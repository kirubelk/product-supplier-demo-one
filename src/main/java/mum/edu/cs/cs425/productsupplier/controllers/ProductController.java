package mum.edu.cs.cs425.productsupplier.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.cs.cs425.productsupplier.models.Product;
import mum.edu.cs.cs425.productsupplier.models.SupplierProduct;
import mum.edu.cs.cs425.productsupplier.service.ISupplierProduct;
import mum.edu.cs.cs425.productsupplier.service.IproductService;

@Controller
public class ProductController {
    
    @Autowired
    private IproductService porService;

     @Autowired 
     private ISupplierProduct supplierService;

    @GetMapping(value = {"/srm/product/list"})
    public ModelAndView getProductList(){

        ModelAndView promodel = new ModelAndView();
        promodel.addObject("products", porService.getProducts());
        promodel.setViewName("product/list");

        return promodel;
    }


    @GetMapping(value = {"/srm/product/new"})
    public String showProductForm(Model model){
         List<SupplierProduct> supplierList = supplierService.getSupplierProductList();
        model.addAttribute("product", new Product());
         model.addAttribute("supplierList", supplierList);
        return "product/new";
    }

    @PostMapping(value = {"/srm/product/new"})
    public String saveProduct(@Valid @ModelAttribute("product") Product product, Model model , BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
        }      
        product = porService.saveProduct(product);
        return "redirect:/srm/product/list";
    }

}