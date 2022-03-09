package com.tajir.activites;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tajir.config.ApiConfig;
import com.tajir.config.ApiService;
import com.tajir.config.ServerConfig;
import com.tajir.databinding.ActivityAuthBinding;
import com.tajir.model.User;

public class AuthActivity extends AppCompatActivity {

    ActivityAuthBinding binding ;
    ApiService apiService;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        apiService = ServerConfig.getAPIService();

        binding.LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginproces();
            }
        });

    }

    private void loginproces() {

        String eamil =  binding.email.getText().toString();
        String password =  binding.pasword.getText().toString();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);


    }


}
