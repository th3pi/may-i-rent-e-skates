package com.mayi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderStatsDaily implements Serializable {


    private static final long serialVersionUID = -3092960492485962032L;

    @Id
    @GeneratedValue
    private int orderStatsMonthlyId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productID")
    private Product mostPopularProduct;

    private double sales;

    private String today;

    public int getOrderStatsMonthlyId() {
        return orderStatsMonthlyId;
    }

    public void setOrderStatsMonthlyId(int orderStatsMonthlyId) {
        this.orderStatsMonthlyId = orderStatsMonthlyId;
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

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }
}
