package com.example.workersfound.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workersfound.R;
import com.example.workersfound.adapter.ServicoAdapter;
import com.example.workersfound.databinding.ActivityHomeBinding;
import com.example.workersfound.fakeDatabases.ServicoBD;
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

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Setup RecyclerView
        RecyclerView recyclerViewServicos = binding.recyclerViewServicos;
        recyclerViewServicos.setLayoutManager(new GridLayoutManager(this, 1));
        servicoAdapter = new ServicoAdapter(this, listaServicos);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(servicoAdapter);
        getServicos();  // Populate the list with initial data

        // OnClick to open profile
        binding.userButton.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this, Profile.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        binding.welcomingUserTxt.setText("Seja bem vindo, " + intent.getExtras().getString("user"));

        // Setup SearchView
        SearchView searchView = binding.pesquisa;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                servicoAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                servicoAdapter.filter(newText);
                return true;
            }
        });
    }

    private void getServicos() {
        ServicoBD bd = ServicoBD.getInstance();
        listaServicos.addAll(bd.getDataList());
        servicoAdapter.filter("");  // Faz com que mostre a lista completa quando inicializar a Home
    }
}
