package com.example.workersfound.fakeDatabases;

import android.graphics.Color;

import com.example.workersfound.R;
import com.example.workersfound.model.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserBD {

    private User user;
    private static UserBD instance;


    private UserBD() {
        user = new User(0, "a", "123456", "matheus", "MG", "Uberlândia", "bairro exemplo", "rua exemplo", "000", "34 999999999");

    }

    public static synchronized UserBD getInstance() {
        if (instance == null) {
            instance = new UserBD();
        }
        return instance;
    }

    public User getUserBy(String email, String senha){
        User result = null;
        if(user != null){
            if(Objects.equals(user.getEmail(), email) && Objects.equals(user.getSenha(), senha)){
                result = getUser();
            }
        }


        return result;
    }

    public User getUser() {
        return user;
    }

    public void replaceUser(User data) {
        user = data;
    }

    public void removeUser(User data) {
        user = null;
    }
}
