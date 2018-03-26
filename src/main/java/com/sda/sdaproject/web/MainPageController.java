package com.sda.sdaproject.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {

    @GetMapping(value = "/main")
    public ModelAndView mainPage(){
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("main","..");
        return mav;
    }
}
