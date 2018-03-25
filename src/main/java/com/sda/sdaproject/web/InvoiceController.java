package com.sda.sdaproject.web;

import com.sda.sdaproject.bo.InvoiceService;
import com.sda.sdaproject.dto.InvoiceCriteriaDto;
import com.sda.sdaproject.repository.InvoiceItemRepository;
import com.sda.sdaproject.repository.InvoiceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceItemRepository invoiceItemRepository;

    public InvoiceController(InvoiceService invoiceService, InvoiceRepository invoiceRepository,
                             InvoiceItemRepository invoiceItemRepository){
        this.invoiceService=invoiceService;
        this.invoiceRepository=invoiceRepository;
        this.invoiceItemRepository=invoiceItemRepository;
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
