package com.mayi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class CustomerJoinDatae implements Serializable {


    private static final long serialVersionUID = -9077445418081483089L;

    @Id
    @GeneratedValue
    private int joinDateId;

    private String joinDate;

    @OneToOne
    private Customer customer;

    public int getJoinDateId() {
        return joinDateId;
    }

    public void setJoinDateId(int joinDateId) {
        this.joinDateId = joinDateId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
