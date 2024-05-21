package com.example.workersfound.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Servico implements Serializable {

    private Integer img;
    private String nome;
    private Integer cor;
    private ArrayList<Professional> professionals = new ArrayList<>();

    public Servico(Integer img, String nome, Integer cor) {
        this.img = img;
        this.nome = nome;
        this.cor = cor;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    public ArrayList<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(ArrayList<Professional> professionals) {
        this.professionals = professionals;
    }
}
