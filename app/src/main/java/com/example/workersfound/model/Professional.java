package com.example.workersfound.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Professional {

    private Integer img;
    private String name;
    private String companyName;
    private String typeOfService;
    private Address address;
    private ArrayList<ProfessionalService> servicos = new ArrayList<>();

    public Professional(Integer img, String name, String companyName, String typeOfService, Address address) {
        this.img = img;
        this.name = name;
        this.companyName = companyName;
        this.typeOfService = typeOfService;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public Address getAddres() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<ProfessionalService> getServicos() {
        return servicos;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

}
