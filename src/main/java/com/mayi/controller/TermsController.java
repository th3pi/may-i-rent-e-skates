package com.mayi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TermsController {

    /**
     * Gets the terms and conditions page
     * @return terms view
     */

    @RequestMapping("/terms")
    public String termsAndCond(){
        return "terms";
    }
}
