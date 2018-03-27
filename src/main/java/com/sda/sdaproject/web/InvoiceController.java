package com.sda.sdaproject.web;

import com.sda.sdaproject.bo.BuyerService;
import com.sda.sdaproject.bo.InvoiceService;
import com.sda.sdaproject.bo.ProductService;
import com.sda.sdaproject.dto.BuyerDto;
import com.sda.sdaproject.dto.InvoiceCriteriaDto;
import com.sda.sdaproject.dto.InvoiceItemDto;
import com.sda.sdaproject.dto.ShortInvoiceDto;
import com.sda.sdaproject.repository.BuyerRepository;
import com.sda.sdaproject.repository.InvoiceItemRepository;
import com.sda.sdaproject.repository.InvoiceRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemRepository invoiceItemRepository;
    private final BuyerService buyerService;
    private final ProductService productService;

    public InvoiceController(InvoiceService invoiceService, InvoiceRepository invoiceRepository,
                             InvoiceItemRepository invoiceItemRepository, BuyerService buyerService, ProductService productService){
        this.invoiceService=invoiceService;
        this.invoiceRepository=invoiceRepository;
        this.invoiceItemRepository=invoiceItemRepository;
        this.buyerService=buyerService;
        this.productService=productService;
    }
    @GetMapping(value = "/invoice")
    public ModelAndView invoicePage(){
        ModelAndView mav = new ModelAndView("invoices");
        mav.addObject("allInvoices", invoiceRepository.findAll());
        mav.addObject("criteria", new InvoiceCriteriaDto());
        return mav;
    }
    @GetMapping(value = "/invoice/{id}")
    public ModelAndView invoiceDetails(@PathVariable("id") Integer id){
        ModelAndView mav = new ModelAndView("invoiceDetail");
        mav.addObject("invoice", invoiceService.findFullInvoiceById(id));
//        mav.addObject("invoiceItems", invoiceItemRepository.findInvoiceItemsByInvoice_Id(id));
        return mav;
    }
    @PostMapping(value = "invoice/search")
    public ModelAndView findInvoiceByAllCriteriaJsp(@ModelAttribute("criteria") InvoiceCriteriaDto iCDto,
                                               BindingResult result, Model model) {
        ModelAndView mav = new ModelAndView("invoices");
        mav.addObject("criteria", new InvoiceCriteriaDto());
        mav.addObject("allInvoices", invoiceService.findByAllCriteria(iCDto));
        return mav;
    }
    @PostMapping(value = "invoice/delete")
    public String deleteInvoice(@RequestParam("invoiceId") String id){
        invoiceService.deleteInvoice(Integer.parseInt(id));
        return "redirect:..invoices";
    }
    @GetMapping(value = "invoice/add")
    public ModelAndView addBuyerToInvoicePage(){
        ModelAndView mav = new ModelAndView("addBuyerToInvoice");
        mav.addObject("buyers",buyerService.findBuyers());
        return mav;
    }
    @GetMapping(value = "addBuyerToInvoice/{id}")
    public ModelAndView addBuyerToInvoice(@PathVariable("id") Integer buyerId){
        ModelAndView mav = new ModelAndView("addProductsToInvoice");
        mav.addObject("shortInvoice", new ShortInvoiceDto());
        mav.addObject("buyer", buyerService.findById(buyerId));
        mav.addObject("date", LocalDate.now());
        mav.addObject("allProducts", productService.findAllProducts());
        return mav;
    }
    @GetMapping
    public ModelAndView showInvoiceDetail(){
        ModelAndView mav = new ModelAndView("invoiceDetail");
        mav.addObject("shortInvoice", new ShortInvoiceDto());
        mav.addObject("date", LocalDate.now());
        mav.addObject("buyer", new BuyerDto());
        mav.addObject("invoiceItems", new InvoiceItemDto());
        return mav;
    }
    @PostMapping(value = "addBuyerToInvoice/addProductsToInvoice")
    public ModelAndView addProductsToInvoice(@ModelAttribute("shortInvoice")ShortInvoiceDto sIDto, Model model,
                                       BindingResult bindingResult){
        ModelAndView mav = new ModelAndView("invoiceDetail");
        mav.addObject("shortInvoice", new ShortInvoiceDto());
        mav.addObject("date", LocalDate.now());
        mav.addObject("buyer", buyerService.findById(sIDto.getBuyerId()));
        mav.addObject("invoiceItems", invoiceService.findInvoiceItemsToInvoice(sIDto));
        return mav;
    }




//    @GetMapping(value = "/edit")
//    public ModelAndView editFullInvoicePage
//
//
//    @PostMapping(value = "editFullInvoice")
//    public ModelAndView editFullInvoiceDto(@ModelAttribute("fullInvoiceAfterEdit")FullInvoiceDto fIDto,
//                                           BindingResult result, Model model){
//        ModelAndView mav = new ModelAndView("invoiceDetail");
//        mav.addObject("invoice", null);
//        return mav;
//    }


}
