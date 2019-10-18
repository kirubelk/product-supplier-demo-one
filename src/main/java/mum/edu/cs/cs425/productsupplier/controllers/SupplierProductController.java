package mum.edu.cs.cs425.productsupplier.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.cs.cs425.productsupplier.models.Product;
import mum.edu.cs.cs425.productsupplier.models.SupplierProduct;
import mum.edu.cs.cs425.productsupplier.service.ISupplierProduct;
import mum.edu.cs.cs425.productsupplier.service.IproductService;

@Controller
public class SupplierProductController {
    
    @Autowired
    private ISupplierProduct supplierService;

    @Autowired
    private IproductService productService;

    @GetMapping(value = {"/srm/supplier/list"})
    public ModelAndView getSupplierList(){

        ModelAndView supplierModel = new ModelAndView();
        supplierModel.addObject("suppliers", supplierService.getSupplierProductList());
        supplierModel.setViewName("supplier/list");
        return supplierModel;
    }


    @GetMapping(value = "/srm/supplier/new")
    public String viewSupplierForm(Model model){
        model.addAttribute("supplier", new SupplierProduct());
        return "supplier/new";
    }

    @PostMapping(value = "/srm/supplier/new")
    public String saveSupplier( @Valid @ModelAttribute("supplier") SupplierProduct product, Model model, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
        }
        product = supplierService.saveSupplier(product);
        return "redirect:/srm/supplier/list";
    }


    @GetMapping(value = {"/srm/supplier/edit/{supplierId}"})
    public String displayEdit(@PathVariable("supplierId") Integer supplierId, Model model){
        model.addAttribute("supplier", supplierService.getSupplier(supplierId));
            return "supplier/edit";
    }

    @PostMapping(value = {"/srm/supplier/edit"})
    public String editSupplier(@Valid @ModelAttribute("supplier") SupplierProduct product, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getAllErrors());
        }

        List<Product> productList = productService.getProducts();

        for(Product pro: productList){
            if(pro.getSupplier().getSupplierId().equals(product.getSupplierId())){
                    return "redirect:/srm/home";
            }
            else{

                product = supplierService.saveSupplier(product);
                return "redirect:/srm/supplier/list";
            }
        }
       
        return null;
    }


    @GetMapping(value = {"/srm/supplier/delete/{supplierId}"})
    public String deleteSupplier(@PathVariable("supplierId") Integer supplierId){
            supplierService.deleteSupplier(supplierId);

            List<Product> productList = productService.getProducts();

            for(Product pro: productList){
                if(pro.getSupplier().getSupplierId().equals(supplierId)){
                return "redirect:/srm/home";
                }
                else{
    
                    return "redirect:/srm/supplier/list";
                }
            }
            return null;
    }


}