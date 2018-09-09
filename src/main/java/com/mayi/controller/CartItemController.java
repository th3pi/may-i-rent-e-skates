package com.mayi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/cart")
public class CartItemController {

    /**
     * Gets cart
     * @param request gets current session context
     * @return cart
     */

    @RequestMapping
    public String get (HttpServletRequest request) {
        return "redirect:/cart/"+request.getSession(true).getId();
    }

    /**
     * @param cartId gets session cartid
     * @param model adds attributes
     * @return cart
     */

    @RequestMapping(value="/{cartId}", method = RequestMethod.GET)
    public String getCart(@PathVariable(value = "cartId") String cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}
