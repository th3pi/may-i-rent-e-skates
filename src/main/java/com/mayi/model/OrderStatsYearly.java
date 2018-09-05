package com.mayi.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderStatsYearly implements Serializable {


    private static final long serialVersionUID = 6750563199109610715L;
    @Id
    @GeneratedValue
    private int orderStatsId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productID")
    private Product mostPopularProduct;

    private double sales;

    private String year;



    public int getOrderStatsId() {
        return orderStatsId;
    }

    public void setOrderStatsId(int orderStatsId) {
        this.orderStatsId = orderStatsId;
    }

    public Product getMostPopularProduct() {
        return mostPopularProduct;
    }

    public void setMostPopularProduct(Product mostPopularProduct) {
        this.mostPopularProduct = mostPopularProduct;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
