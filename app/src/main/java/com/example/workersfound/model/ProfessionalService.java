package com.example.workersfound.model;

import java.io.Serializable;

public class ProfessionalService implements Serializable {

    private String type;
    private Double price;

    public ProfessionalService(String type, Double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
