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

    @RequestMapping("/product/addProduct")
    public String addProduct(Model model){
        Product product = new Product();

        model.addAttribute("product", product);
        return "addProduct";
    }

    @RequestMapping("/product/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Product product = productService.getProductById(id);

        model.addAttribute("product", product);
        return "editProduct";
    }

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
