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
        ProfessionalBD professionalBD = ProfessionalBD.getInstance();

        Servico servico1 = new Servico(R.drawable.beard_ic, "BARBEIRO", Color.parseColor("#2F528F"));
        Servico servico2 = new Servico(R.drawable.hairmaker_ic, "CABELEIREIRO", Color.parseColor("#FF09DC"));
        Servico servico3 = new Servico(R.drawable.dressmaker_ic, "COSTUREIRO", Color.parseColor("#FFD966"));
        Servico servico4 = new Servico(R.drawable.makeup_ic, "MANICURE", Color.parseColor("#00D0B2"));

        servico1.getProfessionals().add(professionalBD.getProfessionalById(1));
        servico2.getProfessionals().add(professionalBD.getProfessionalById(2));
        servico3.getProfessionals().add(professionalBD.getProfessionalById(3));
        servico4.getProfessionals().add(professionalBD.getProfessionalById(4));
        servico1.getProfessionals().add(professionalBD.getProfessionalById(5));
        servico2.getProfessionals().add(professionalBD.getProfessionalById(6));
        servico3.getProfessionals().add(professionalBD.getProfessionalById(7));
        servico4.getProfessionals().add(professionalBD.getProfessionalById(8));

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
