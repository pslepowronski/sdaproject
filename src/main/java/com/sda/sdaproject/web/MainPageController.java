package com.sda.sdaproject.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class MainPageController {

    @GetMapping(value = "/main")
    public ModelAndView mainPage(){
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("main","..");
        return mav;
    }
}
