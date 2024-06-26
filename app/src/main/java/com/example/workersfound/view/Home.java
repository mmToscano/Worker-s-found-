package com.example.workersfound.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.workersfound.adapter.ServicoAdapter;
import com.example.workersfound.databinding.ActivityHomeBinding;
import com.example.workersfound.fakeDatabases.ServicoBD;
import com.example.workersfound.model.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private ServicoAdapter servicoAdapter;
    private ArrayList<Service> listaServices = new ArrayList<>();

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
        servicoAdapter = new ServicoAdapter(this, listaServices);
        recyclerViewServicos.setHasFixedSize(true);
        recyclerViewServicos.setAdapter(servicoAdapter);
        getServicos();  // Populate the list with initial data

        // OnClick to open profile
        binding.userButton.setOnClickListener(view -> {
            Intent intent = new Intent(Home.this, Profile.class);
            startActivity(intent);
        });

        Intent intent = getIntent();
        binding.welcomingUserTxt.setText("Seja bem vindo, " + intent.getExtras().getString("nomeUser"));

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
        listaServices.addAll(bd.getDataList());
        servicoAdapter.filter("");  // Faz com que mostre a lista completa quando inicializar a Home
        System.out.println("Começando connection");
        getServicosAPI("http://localhost:9000/services");
    }

    private void getServicosAPI(String URL){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    // Loop through the array elements
                    for (int i = 0; i < response.length(); i++) {
                        // Get current json object
                        JSONObject jsonObject = response.getJSONObject(i);

                        // Get the JSON fields
                        String id = jsonObject.getString("service_id");

                        System.out.println(id);

                        // You can add the title to a TextView or log it for now
                        //binding.textExample.append(title + "\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error
                binding.textExample.setText(error.toString());
            }
        });
        queue.add(jsonArrayRequest);
    }



    /*
    private void getServicosAPI(String URL){
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) { //jsonObject é o objeto retornado. O getString é a maneira de pegar um campo em específico
                try{
                    binding.textExample.setText(jsonObject.getString("title"));
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //binding.textExample.setText(error.toString());
            }
        });
        queue.add(jsonObjectRequest);

    }

     */
}
