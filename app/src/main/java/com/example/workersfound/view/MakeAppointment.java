package com.example.workersfound.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.workersfound.R;
import com.example.workersfound.databinding.ActivityMakeAppointmentBinding;

public class MakeAppointment extends AppCompatActivity {

    private ActivityMakeAppointmentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

    }
}