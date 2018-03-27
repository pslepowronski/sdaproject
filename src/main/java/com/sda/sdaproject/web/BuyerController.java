package com.sda.sdaproject.web;

import com.sda.sdaproject.bo.BuyerService;
import com.sda.sdaproject.dto.BuyerCriteriaDto;
import com.sda.sdaproject.dto.NewBuyerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyerController {

    private final BuyerService service;

    @Autowired
    public BuyerController(BuyerService service) {
        this.service = service;}

    @GetMapping(value = "/buyers")
    public ModelAndView buyerPage() {
        ModelAndView mav = new ModelAndView("buyers");
        mav.addObject("criteria", new BuyerCriteriaDto());
        mav.addObject("buyers", service.findBuyers());
        return mav;
    }

    @GetMapping(value = "/buyer/{id}")
    public ModelAndView buyerDetail(@PathVariable("id")Integer id){
        ModelAndView mav = new ModelAndView("buyerDetails");
        mav.addObject("buyer",service.findCostDetails(id));
        return mav;
    }

    @PostMapping(value = "buyer/delete")
    public String deleteBuyer(@RequestParam(name="buyerId") String id){
        service.deleteBuyer(Integer.valueOf(id));
        return "redirect:../buyers";
    }

    @GetMapping(value = "buyer/add")
    public String addBuyer(Model model){
        model.addAttribute("newBuyer", new NewBuyerDto());
        return "editBuyer";
    }

    @PostMapping(value = "buyer/add")
    public String saveBuyer(@ModelAttribute("newBuyer")NewBuyerDto form,
        BindingResult result, Model model){

        if (!result.hasErrors()){
            service.addBuyer(form);
        }

        return  "redirect:../buyers";

    }

    @PostMapping(value = "buyers/search")
    public String searchBuyer(
            @ModelAttribute("criteria")BuyerCriteriaDto criteria,
            BindingResult bindingResult, Model model){
        model.addAttribute("buyers", service.findByAllCriteria(criteria));
        return "buyers";
    }

}
