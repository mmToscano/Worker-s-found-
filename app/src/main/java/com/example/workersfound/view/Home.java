package com.example.workersfound.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.R;
import com.example.workersfound.adapter.ServicoAdapter;
import com.example.workersfound.databinding.ActivityHomeBinding;
import com.example.workersfound.fakeDatabases.ServicoBD;
import com.example.workersfound.model.Professional;
import com.example.workersfound.model.Servico;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private ServicoAdapter servicoAdapter;
    private ArrayList<Servico> listaServicos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //cria o recyclerView com os serviços
        RecyclerView recyclerViewServicos = binding.recyclerViewServicos;
        recyclerViewServicos.setLayoutManager(new GridLayoutManager(this, 1));
        servicoAdapter = new ServicoAdapter(this, listaServicos);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(servicoAdapter);
        getServicos();

        //onClick para abrir o perfil
        //dá para tentar mandar por aqui as cores. Talvez seja uma boa ideia
        binding.userButton.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this, Profile.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        binding.welcomingUserTxt.setText("Seja bem vindo, " + intent.getExtras().getString("nome"));


    }

    //método que simula o fetch de um banco de dados
    private void getServicos(){
        //fake database. É aqui que acontecerá a conexão com o banco de dados
        ServicoBD bd = ServicoBD.getInstance();
        listaServicos.addAll(bd.getDataList());


    }
}