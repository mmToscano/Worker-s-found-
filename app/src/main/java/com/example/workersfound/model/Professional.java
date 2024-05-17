package com.example.workersfound.model;

import java.util.ArrayList;

public class Professional {

    private String name;

    private String typeOfService;
    private String cidade;
    private ArrayList<String> servicos = new ArrayList<>();

    public Professional(String name, String typeOfService, String cidade) {
        this.name = name;
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

    public void setServicos(ArrayList<String> servicos) {
        this.servicos = servicos;
    }
}
