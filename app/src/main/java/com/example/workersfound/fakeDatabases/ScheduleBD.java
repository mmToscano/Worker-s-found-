package com.example.workersfound.fakeDatabases;

import com.example.workersfound.model.Professional;
import com.example.workersfound.model.Schedule;

import java.util.ArrayList;

public class ScheduleBD {

    private ArrayList<Schedule> dataList;
    private static ScheduleBD instance;


    private ScheduleBD() {
        ArrayList<Professional> professionalDataList = ServicoBD.getInstance().getProfessionals();
        dataList = new ArrayList<>();

//        Schedule schedule1 = new Schedule(professionalDataList.get(0), 5, 2, 2024, 17, 35);
//        Schedule schedule2 = new Schedule(professionalDataList.get(1), 5, 2, 2024, 17, 35);
//        Schedule schedule3 = new Schedule(professionalDataList.get(1), 5, 2, 2024, 17, 35);
//        Schedule schedule4 = new Schedule(professionalDataList.get(3), 5, 2, 2024, 17, 35);
//
//        dataList.add(schedule1);
//        dataList.add(schedule2);
//        dataList.add(schedule3);
//        dataList.add(schedule4);

    }

    public static synchronized ScheduleBD getInstance() {
        if (instance == null) {
            instance = new ScheduleBD();
        }
        return instance;
    }

    public ArrayList<Schedule> getDataList() {
        return dataList;
    }

    public void addData(Schedule data) {
        dataList.add(data);
    }

    public void removeData(Schedule data) {
        dataList.remove(data);
    }
}
