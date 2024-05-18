package com.example.workersfound.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.R;
import com.example.workersfound.adapter.ProfessionalAdapter;
import com.example.workersfound.adapter.ServicoAdapter;
import com.example.workersfound.databinding.ActivityProfessionalsListingBinding;
import com.example.workersfound.fakeDatabases.ServicoBD;
import com.example.workersfound.model.Professional;

import java.util.ArrayList;

public class ProfessionalsListing extends AppCompatActivity {

    private ActivityProfessionalsListingBinding binding;
    private ProfessionalAdapter professionalAdapter;
    private ArrayList<Professional> listaProfessionals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfessionalsListingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //cria o recyclerView e habilita ele para receber elementos
        RecyclerView recyclerViewProfessionals = binding.recyclerViewProfessionals;
        recyclerViewProfessionals.setLayoutManager(new GridLayoutManager(this, 1));
        professionalAdapter = new ProfessionalAdapter(this, listaProfessionals);
        recyclerViewProfessionals.setHasFixedSize(true);
        recyclerViewProfessionals.setAdapter(professionalAdapter);
        //preenche o array que será usado no recyclerView
        getProfessionals();
    }

    private void getProfessionals(){
        String type = getIntent().getExtras() != null ? getIntent().getExtras().getString("service_type") : null;

        ServicoBD bd = ServicoBD.getInstance();
        listaProfessionals.addAll(bd.getProfessionalsByType(type));
    }
}