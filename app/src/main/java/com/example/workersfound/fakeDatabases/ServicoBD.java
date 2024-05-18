package com.example.workersfound.fakeDatabases;

import android.graphics.Color;

import com.example.workersfound.R;
import com.example.workersfound.model.Address;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.ProfessionalService;
import com.example.workersfound.model.Servico;

import java.util.ArrayList;
import java.util.Objects;

public class ServicoBD {

    private ArrayList<Servico> dataList;
    private static ServicoBD instance;


    private ServicoBD() {
        dataList = new ArrayList<>();

        Professional professional1 = new Professional(R.drawable.user_ic, "Joao", "Launge barbearia", "BARBEIRO", new Address("Uberlândia", "Jardim das palmeiras", "R. da secretária", "000"));
        Professional professional2 = new Professional(R.drawable.user_ic,"Maria","Maria cortes", "CABELEIREIRO", new Address("Uberlândia", "Jardim Patrícia", "R. Valdivíno josé Gomes", "000"));
        Professional professional3 = new Professional(R.drawable.user_ic,"Jonas","Jonas bacana", "COSTUREIRO",  new Address("Uberlândia", "Luizote de freitas", "R. Roberto Margonari", "000"));
        Professional professional4 = new Professional(R.drawable.user_ic,"Zuleide","Zuleide maluca", "MANICURE", new Address("Uberlândia", "Tocantins", "R. Agenor Borges", "000"));

        professional1.getServicos().add(new ProfessionalService("corte de cabelo", 35.0d));
        professional2.getServicos().add(new ProfessionalService("corte de cabelo", 35.0d));
        professional3.getServicos().add(new ProfessionalService("costura", 20.0d));
        professional4.getServicos().add(new ProfessionalService("pintar unha", 30.0));

        Servico servico1 = new Servico(R.drawable.beard_ic, "BARBEIRO", Color.parseColor("#2F528F"));
        Servico servico2 = new Servico(R.drawable.hairmaker_ic, "CABELEIREIRO", Color.parseColor("#FF09DC"));
        Servico servico3 = new Servico(R.drawable.dressmaker_ic, "COSTUREIRO", Color.parseColor("#FFD966"));
        Servico servico4 = new Servico(R.drawable.makeup_ic, "MANICURE", Color.parseColor("#00D0B2"));

        servico1.getProfessionals().add(professional1);
        servico2.getProfessionals().add(professional2);
        servico3.getProfessionals().add(professional3);
        servico4.getProfessionals().add(professional4);

        dataList.add(servico1);
        dataList.add(servico2);
        dataList.add(servico3);
        dataList.add(servico4);

    }

    public static synchronized ServicoBD getInstance() {
        if (instance == null) {
            instance = new ServicoBD();
        }
        return instance;
    }

    public ArrayList<Servico> getDataList() {
        return dataList;
    }

    public ArrayList<Professional> getProfessionals(){
        ArrayList<Professional> professionals = new ArrayList<>();

        for(Servico item: dataList){
            professionals.addAll(item.getProfessionals());
        }

        return professionals;
    }

    public ArrayList<Professional> getProfessionalsByType(String type){
        ArrayList<Professional> professionals = new ArrayList<>();

        for(Servico item: dataList){
            if(Objects.equals(item.getNome(), type)){
                professionals.addAll(item.getProfessionals());
            }

        }

        return professionals;
    }

    public void addData(Servico data) {
        dataList.add(data);
    }

    public void removeData(Servico data) {
        dataList.remove(data);
    }

}
