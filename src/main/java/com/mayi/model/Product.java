package com.mayi.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String productID;
    private String productSku;
    private String productName;
    private String productDescription;
    private String productManufacturer;
    private String productType;
    private String productSpeed;
    private String productRange;
    private String productWeight;
    private String productRechargeTime;
    private String productRentLimit;
    private int productQuantity;
    private double productPrice;

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

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
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
}
