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
    private String cidade;
    private ArrayList<String> servicos = new ArrayList<>();

    public Professional(Integer img, String name, String companyName, String typeOfService, String cidade) {
        this.img = img;
        this.name = name;
        this.companyName = companyName;
        this.typeOfService = typeOfService;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public ArrayList<String> getServicos() {
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
