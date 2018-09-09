package com.mayi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    /**
     * Controls the login page. Validates username and password
     * @param error sends the error to login page
     * @param logout gets the logout message
     * @param model sends msg attributes to login view
     * @return the login view
     */

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false)String error, @RequestParam(value = "logout", required = false)String logout, Model model){
        if(error != null){
            model.addAttribute("error","Invalid username or password");
        }

        if(logout != null){
            model.addAttribute("msg","You have been logged out successfully.");
        }

        return "login";
    }
}
