package com.example.workersfound.view;

import android.graphics.Color;
import android.os.Bundle;

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

        RecyclerView recyclerViewServicos = binding.recyclerViewServicos;
        recyclerViewServicos.setLayoutManager(new GridLayoutManager(this, 1));
        servicoAdapter = new ServicoAdapter(this, listaServicos);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(servicoAdapter);
        getServicos();

    }

    private void getServicos(){
        //fake database. É aqui que acontecerá a conexão com o banco de dados
        Professional professional1 = new Professional("Joao", "BARBEIRO", "Uberlandia");
        Professional professional2 = new Professional("Maria", "CABELEIREIRO", "Uberlandia");
        Professional professional3 = new Professional("Jonas", "COSTUREIRO", "Uberlandia");
        Professional professional4 = new Professional("Zuleide", "MANICURE", "Uberlandia");

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

        listaServicos.add(servico1);
        listaServicos.add(servico2);
        listaServicos.add(servico3);
        listaServicos.add(servico4);
    }
}