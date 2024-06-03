package com.example.workersfound;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.workersfound.databinding.ActivityMainBinding;
import com.example.workersfound.fakeDatabases.ProfessionalBD;
import com.example.workersfound.fakeDatabases.ScheduleBD;
import com.example.workersfound.fakeDatabases.ServicoBD;
import com.example.workersfound.fakeDatabases.UserBD;
import com.example.workersfound.model.User;
import com.example.workersfound.requestHandlers.UserRequestHandler;
import com.example.workersfound.view.Home;
import com.example.workersfound.view.Register;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public User user;
    private ActivityMainBinding binding;

    UserRequestHandler userRequestHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); //NÃO PODE ESQUECER. A PARTIR DO MOMENTO QUE DECLARAR UM BINDING, TEM QUE FAZER ISSO AQUI

        userRequestHandler = new UserRequestHandler(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.txtEmail.setText("");
        binding.txtPassword.setText("");

        userRequestHandler.getUser(getString(R.string.path) + "userAndAddress/1", new UserRequestHandler.GetUserListener() {
            @Override
            public void onSuccess(User newUser) {
                user = newUser;
                Log.d("usuario", user.toString());
            }

            @Override
            public void onError(VolleyError error) {
                Log.d("erro", error.toString());
            }
        });

        binding.buttonLogin.setOnClickListener(view -> {
            String email = binding.txtEmail.getText().toString();
            String senha = binding.txtPassword.getText().toString();

            if(email.isEmpty()){
                mensagem(view, "Coloque seu nome");
            }
            if(senha.isEmpty()){
                mensagem(view, "Coloque sua senha");
            }
            if(senha.length() <= 5){
                mensagem(view, "A senha é muito curta");
            }
            if(user.verificarSeExiste(email, senha)){
                navegarParaHome(user.getNome());
            }else{
                mensagem(view, "O email ou a senha estão incorretos");
            }

        });

        binding.buttonRegister.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Register.class);
            startActivity(intent);
        });

    }



    //mensagem de erro caso o usuário não insira o email ou a senha
    private void mensagem(View view, String mensagem){
        Snackbar snackbar = Snackbar.make(view, mensagem, BaseTransientBottomBar.LENGTH_SHORT);
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"));
        snackbar.setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }

    private void navegarParaHome(String nome){
        Intent intent = new Intent(MainActivity.this, Home.class); //cria a intent para mudar de página
        intent.putExtra("nomeUser", nome); //coloca na intent uma info que vai ser enviada para a outra activity
        startActivity(intent);
    }

}