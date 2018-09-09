package com.mayi.controller.admin;


import com.mayi.dao.ProductDao;
import com.mayi.model.Product;
import com.mayi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductAdminController {

    private Path path;

    @Autowired
    ProductService productService;

    /**
     * This method redirect to the add product page.
     * @param model adds the product attributes the product page
     * @return returns the add product page
     */

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model){
        Product product = new Product();

        model.addAttribute("product", product);
        return "addProduct";
    }

    /**
     * With RequestMethod.POST this method adds the product details to the database. Including image.
     * @param product adds the product details using the pojo class
     * @param result checks for errors
     * @param request gets the current session context
     * @return after done, takes employee to product inventory page
     */

    @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
    public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "addProduct";
        }

        productService.addProduct(product);

        MultipartFile multipartFile = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + product.getProductID()+".png");

        if(multipartFile != null && !multipartFile.isEmpty()){
            try {
                multipartFile.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving failed.");
            }
        }

        return "redirect:/admin/productInventory";
    }

    /**
     * This method redirect to the edit product page. Pre filled with previous details
     * @param model adds the product attributes the product page
     * @return returns the add product page
     */


    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);
        return "editProduct";
    }

    /**
     * With RequestMethod.POST this method edit the product details to the database. Including image.
     * @param product adds the product details using the pojo class
     * @param result checks for errors
     * @param request gets the current session context
     * @return after done, takes employee to product inventory page
     */

    @RequestMapping(value = "/product/editProduct", method = RequestMethod.POST)
    public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request){
        if(result.hasErrors()){
            return "editProduct";
        }

        MultipartFile multipartFile = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + product.getProductID()+".png");

        if(multipartFile != null && !multipartFile.isEmpty()){
            try {
                multipartFile.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Product Image Saving failed.");
            }
        }

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    /**
     * Deletes product including all product details and image
     * @param id gets the product id.
     * @param model not in use at the moment.
     * @param request get the current session context
     * @return redirects to the product inventory page
     */

    @RequestMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request){
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        try {
            Files.deleteIfExists(Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + id +".png"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't find file");
        }

        Product product = productService.getProductById(id);
        productService.deleteProduct(product);
        return "redirect:/admin/productInventory";
    }
}
