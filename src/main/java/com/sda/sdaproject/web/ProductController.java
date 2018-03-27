package com.sda.sdaproject.web;

import com.sda.sdaproject.bo.ProductService;
import com.sda.sdaproject.dto.ProductCriteriaDto;
import com.sda.sdaproject.dto.ProductDto;
import com.sda.sdaproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Autowired
    public ProductController(ProductRepository productRepository, ProductService productService){
        this.productRepository = productRepository;
        this.productService = productService;
    }

    @GetMapping(value = "/products")
    public ModelAndView allProdctsPage(){
        ModelAndView mav = new ModelAndView("products");
        mav.addObject("allProducts", productService.findAllProducts());
        mav.addObject("productCriteria", new ProductCriteriaDto());
        mav.addObject("quantityProduct", new ProductDto());
        return mav;
    }
    @PostMapping(value = "products/search")
    public String searchProductByCriteria(@ModelAttribute("productCriteria") ProductCriteriaDto pCDto,
                                                BindingResult result, Model model){
        model.addAttribute("allProducts", productService.findByAllCriteria(pCDto));
        return "products";
    }
    @GetMapping(value = "products/add")
    public ModelAndView addNewProducts(){
        ModelAndView mav = new ModelAndView("productAdd");
        mav.addObject("newProduct", new ProductDto());
        return mav;
    }
    @PostMapping(value = "products/add")
    public String saveNewProduct(@ModelAttribute("newProduct") ProductDto pDto,
                                       BindingResult result, Model model){
        productService.addNewProduct(pDto);
        return "redirect:../products";
    }
    @PostMapping(value = "products/complement")
    public String complementProduct(@RequestParam("productId") String prodId,
                                    @RequestParam("productQuantity") String quantity){
        productService.complementProduct(Integer.valueOf(prodId),Integer.valueOf(quantity));
        return "redirect:../products";
    }
    @PostMapping(value = "products/delete")
    public String deleteInvoice(@RequestParam("productId") String id){
        productService.deleteProductById(Integer.valueOf(id));
        return "redirect:../products";
    }

}
