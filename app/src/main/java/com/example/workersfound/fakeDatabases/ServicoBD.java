package com.example.workersfound.fakeDatabases;

import android.graphics.Color;

import com.example.workersfound.R;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.Servico;

import java.util.ArrayList;
import java.util.Objects;

public class ServicoBD {

    private ArrayList<Servico> dataList;
    private static ServicoBD instance;


    private ServicoBD() {
        dataList = new ArrayList<>();

        Professional professional1 = new Professional(R.drawable.user_ic, "Joao", "Launge barbearia", "BARBEIRO", "Uberlandia");
        Professional professional2 = new Professional(R.drawable.user_ic,"Maria","Maria cortes", "CABELEIREIRO", "Uberlandia");
        Professional professional3 = new Professional(R.drawable.user_ic,"Jonas","Jonas bacana", "COSTUREIRO", "Uberlandia");
        Professional professional4 = new Professional(R.drawable.user_ic,"Zuleide","Zuleide maluca", "MANICURE", "Uberlandia");

        professional1.getServicos().add("corte de cabelo");
        professional2.getServicos().add("corte de cabelo");
        professional3.getServicos().add("costura");
        professional4.getServicos().add("pintar unha");

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
