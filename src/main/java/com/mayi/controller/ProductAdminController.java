package com.mayi.controller;

import com.mayi.dao.ProductDao;
import com.mayi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@Controller
public class ProductAdminController {

    private Path path;

    @Autowired
    ProductDao productDao;

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
    public String addProductPost(@ModelAttribute("product") Product product, HttpServletRequest request){
        productDao.addProduct(product);
//        List<MultipartFile> files = product.getProductImages();
//        List<String> fileNames = new ArrayList<String>();
//        int counter = 0;
//        if(null != files && files.size() > 0){
//            for(MultipartFile multipartFile : files){
//                String fileName = product.getProductID() + "num" + counter + ".png";
//                counter++;
//                fileNames.add(fileName);
//
//                File imageFile = new File(request.getServletContext().getRealPath("/"),fileName);
//                try{
//                    multipartFile.transferTo(imageFile);
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//        }

//        List<MultipartFile> img = product.getProductImages();
//        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
//        for(MultipartFile multipartFile : img) {
//            path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + product.getProductID()+".png");
//
//            if (multipartFile != null && !img.isEmpty()) {
//                try {
//                    multipartFile.transferTo(new File(path.toString()));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    throw new RuntimeException("Product image saving failed", e);
//                }
//            }
//        }


        MultipartFile img = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + product.getProductID()+".png");

        if(img != null && !img.isEmpty()){
            try{
                img.transferTo(new File(path.toString()));
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("admin/productInventory/deleteProduct/{id}")
    public String deleteProduct(@PathVariable String id, Model model, HttpServletRequest request){
        productDao.deleteProduct(id);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        try {
            Files.deleteIfExists(Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + id +".png"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't find file");
        }
        return "redirect:/admin/productInventory";
    }

    @RequestMapping("admin/productInventory/editProduct/{id}")
    public String editProduct(@PathVariable String id, Model model, HttpServletRequest request){
        Product product = productDao.getProductById(id);
        model.addAttribute(product);

        return "editProduct";
    }

    @RequestMapping(value = "admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProductPost(@ModelAttribute("product") Product product, Model model, HttpServletRequest request){
        MultipartFile multipartFile = product.getProductImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\img\\" + product.getProductID()+".png");

        if(multipartFile != null && !multipartFile.isEmpty()){
            try{
                multipartFile.transferTo(new File(path.toString()));
            }catch (Exception e){
                throw new RuntimeException("Couldn't find image", e);
            }
        }

        productDao.editProduct(product);

        return "redirect:/admin/productInventory";
    }

}
