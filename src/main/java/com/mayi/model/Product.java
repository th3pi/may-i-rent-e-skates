package com.mayi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Product implements Serializable {


    private static final long serialVersionUID = -354687566242275740L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;
    private String productSku;

    @NotEmpty (message = "Product name required")
    private String productName;
    private String productDescription;
    private String productManufacturer;
    private String productType;
    private String productSpeed;
    private String productRange;
    private String productWeight;
    private String productRechargeTime;
    private String productRentLimit;

    @NotEmpty (message = "Product quantity required")
    private String productQuantity;

    @NotEmpty (message = "Product price required")
    private double productPrice;

    @Transient
    private MultipartFile productImage;

    @Transient
    private List<MultipartFile> productImages;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public List<MultipartFile> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<MultipartFile> productImages) {
        this.productImages = productImages;
    }

    public String getProductSpeed() {
        return productSpeed;
    }

    public void setProductSpeed(String productSpeed) {
        this.productSpeed = productSpeed;
    }

    public String getProductRange() {
        return productRange;
    }

    public void setProductRange(String productRange) {
        this.productRange = productRange;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getProductRechargeTime() {
        return productRechargeTime;
    }

    public void setProductRechargeTime(String productRechargeTime) {
        this.productRechargeTime = productRechargeTime;
    }

    public String getProductRentLimit() {
        return productRentLimit;
    }

    public void setProductRentLimit(String productRentLimit) {
        this.productRentLimit = productRentLimit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
