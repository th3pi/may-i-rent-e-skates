package com.mayi.controller;

import com.mayi.model.Product;
import com.mayi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {


    @Autowired
    private ProductService productService;


    /**
     * Gets all the products
     * @param model adds all products to the shop
     * @return the shop view
     */

    @RequestMapping("/shop")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products",products);

        return "shop";
    }

    /**
     * Gets all the products
     * @param model adds all products to the shop
     * @return the shop view
     */

    @RequestMapping("/shop/skateboards")
    public String getSkateboards(Model model){
        List<Product> products = productService.getProductsByType("Skateboard");
        model.addAttribute("skateboards",products);
        return "skateboards";
    }

    /**
     * Gets all the scooters
     * @param model adds all scooters to the scooter view
     * @return the scooters view
     */

    @RequestMapping("/shop/scooters")
    public String getScooters(Model model){
        List<Product> products = productService.getProductsByType("Scooter");
        model.addAttribute("scooters",products);
        return "scooters";
    }

    /**
     * Gets all the cycles
     * @param model adds all cycles to the cycles
     * @return the cycles view
     */

    @RequestMapping("/shop/cycles")
    public String getCycles(Model model){
        List<Product> products = productService.getProductsByType("Bicycle");
        model.addAttribute("cycles",products);
        return "cycles";
    }

    /**
     * Adds details to the product page
     * @param productId the product to be viewed
     * @param model adds all the details to product page
     * @return the product page
     * @throws IOException
     */

    @RequestMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException{
        Product product = productService.getProductById(productId);

        //Suggests other products based on the current product being viewed.
        if(product.getProductType().equals("Skateboard")){
            List<Product> products = productService.getProductsByType("Skateboard");
            model.addAttribute("contextualProducts",products);
        }else if(product.getProductType().equals("Scooter")){
            List<Product> products = productService.getProductsByType("Scooter");
            model.addAttribute("contextualProducts",products);
        }else if(product.getProductType().equals("Bicycle")){
            List<Product> products = productService.getProductsByType("Scooter");
            model.addAttribute("contextualProducts",products);
        }
        model.addAttribute("product", product);
        return "viewProduct";
    }
}
