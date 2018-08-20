package com.mayi.controller;

import com.mayi.dao.ProductDao;
import com.mayi.dao.impl.ProductDaoImpl;
import com.mayi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/productList")
    public String getProducts(Model model) throws SQLException {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);

        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productID}")
    public String viewProduct(@PathVariable String productID, Model model) throws IOException {
        Product product = productDao.getProductById(productID);
        model.addAttribute(product);
        return "viewProduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) throws SQLException {
        List<Product> products = productDao.getAllProducts();
        model.addAttribute("products",products);

        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        product.setProductType("Skateboard");
        product.setProductQuantity(10);
        product.setProductManufacturer("Boostedboard");

        model.addAttribute(product);

        return "addProduct";
    }
    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product") Product product){
        productDao.addProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model){
        productDao.deleteProduct(id);

        return "redirect:/admin/productInventory";
    }
}
