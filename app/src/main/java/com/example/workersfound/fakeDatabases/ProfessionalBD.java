package com.example.workersfound.fakeDatabases;

import android.graphics.Color;

import com.example.workersfound.R;
import com.example.workersfound.model.Address;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.ProfessionalService;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.Servico;

import java.util.ArrayList;
import java.util.Objects;

public class ProfessionalBD {

    private ArrayList<Professional> dataList;
    private static ProfessionalBD instance;

    private ProfessionalBD() {
        dataList = new ArrayList<>();

        Professional professional1 = new Professional(1, R.drawable.user_ic, "Joao", "Launge barbearia", "BARBEIRO", new Address("Uberlândia", "Jardim das palmeiras", "R. da secretária", "000"));
        Professional professional2 = new Professional(2, R.drawable.user_ic,"Maria","Maria cortes", "CABELEIREIRO", new Address("Uberlândia", "Jardim Patrícia", "R. Valdivíno josé Gomes", "000"));
        Professional professional3 = new Professional(3, R.drawable.user_ic,"Jonas","Jonas bacana", "COSTUREIRO",  new Address("Uberlândia", "Luizote de freitas", "R. Roberto Margonari", "000"));
        Professional professional4 = new Professional(4, R.drawable.user_ic,"Zuleide","Zuleide maluca", "MANICURE", new Address("Uberlândia", "Tocantins", "R. Agenor Borges", "000"));

        Professional professional5 = new Professional(5, R.drawable.user_ic, "Zacarias", "Zacarias barbearia", "BARBEIRO", new Address("Uberlândia", "Jardim das palmeiras", "R. da secretária", "000"));
        Professional professional6 = new Professional(6, R.drawable.user_ic,"Carlos","Carlos tesoura", "CABELEIREIRO", new Address("Uberlândia", "Jardim Patrícia", "R. Valdivíno josé Gomes", "000"));
        Professional professional7 = new Professional(7, R.drawable.user_ic,"Zulu","Zulu bacana", "COSTUREIRO",  new Address("Uberlândia", "Luizote de freitas", "R. Roberto Margonari", "000"));
        Professional professional8 = new Professional(8, R.drawable.user_ic,"Jania","Jania unhas", "MANICURE", new Address("Uberlândia", "Tocantins", "R. Agenor Borges", "000"));


        professional1.getServicos().add(new ProfessionalService("corte de cabelo", 35.0d));
        professional2.getServicos().add(new ProfessionalService("corte de cabelo", 35.0d));
        professional3.getServicos().add(new ProfessionalService("costura", 20.0d));
        professional4.getServicos().add(new ProfessionalService("pintar unha", 30.0));
        professional5.getServicos().add(new ProfessionalService("corte de cabelo", 35.0d));
        professional6.getServicos().add(new ProfessionalService("corte de cabelo", 35.0d));
        professional7.getServicos().add(new ProfessionalService("costura", 20.0d));
        professional8.getServicos().add(new ProfessionalService("pintar unha", 30.0));

        dataList.add(professional1);
        dataList.add(professional2);
        dataList.add(professional3);
        dataList.add(professional4);
        dataList.add(professional5);
        dataList.add(professional6);
        dataList.add(professional7);
        dataList.add(professional8);

    }

    public static synchronized ProfessionalBD getInstance() {
        if (instance == null) {
            instance = new ProfessionalBD();
        }
        return instance;
    }

    public ArrayList<Professional> getDataList() {
        return dataList;
    }

    public Professional getProfessionalById(int id){
        Professional professional = null;

        for(Professional item: dataList){
            if(item.getProfessionalId() == id){
                professional = item;
            }
        }

        return professional;
    }

    public ArrayList<Professional> getProfessionalsByType(String type){
        ArrayList<Professional> professionals = new ArrayList<>();

        for(Professional item: dataList){
            if(Objects.equals(item.getTypeOfService(), type)){
                professionals.add(item);
            }

        }

        return professionals;
    }

    public void addData(Professional data) {
        dataList.add(data);
    }

    public void removeData(Professional data) {
        dataList.remove(data);
    }
}
