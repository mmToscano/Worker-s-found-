package com.example.workersfound.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {

    private Integer userId;
    private String email;
    private String senha; //String porque isso aqui é senha. valores que não serão utilizados para operações matemáticas devem ser string, mesmo que sejam uma sequência de números
    private String nome;
    private Address address;
    private String phoneNumber;
    private ArrayList<Schedule> schedules = new ArrayList<>();

    public User(Integer userId, String email, String senha, String nome, Address address, String phoneNumber) {
        this.userId = userId;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public static User fromJson(JSONObject jsonObject){
        try{
            Integer userId = jsonObject.getInt("user_id");
            String email = jsonObject.getString("email");
            String senha = jsonObject.getString("senha");
            String nome = jsonObject.getString("nome");
            String phoneNumber = jsonObject.getString("numero_telefone");
            Address address = new Address(jsonObject.getInt("address_id"), jsonObject.getString("city"), jsonObject.getString("district"), jsonObject.getString("street_name"), jsonObject.getString("house_number"));
            return new User(userId, email, senha, nome, address, phoneNumber);
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean verificarSeExiste(String email, String senha){
        if(Objects.equals(this.getEmail(), email) && Objects.equals(this.getSenha(), senha)){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", schedules=" + schedules +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
