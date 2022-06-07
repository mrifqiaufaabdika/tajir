package com.tajir.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tajir.config.ApiService;
import com.tajir.config.ServerConfig;
import com.tajir.databinding.ActivityAuthBinding;
import com.tajir.model.User;
import com.tajir.respones.ResponseAuth;
import com.tajir.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends AppCompatActivity {

    ActivityAuthBinding binding ;
    ApiService apiService;
    SessionManager sessionManager;
    User user;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sessionManager = new SessionManager(this);
        apiService = ServerConfig.getAPIService();
        context = this;



        binding.LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginproces();
            }
        });

    }

    private void loginproces() {

        String email =  binding.email.getText().toString();
        String password =  binding.pasword.getText().toString();

        apiService.auth(email,password).enqueue(new Callback<ResponseAuth>() {
            @Override
            public void onResponse(Call<ResponseAuth> call, Response<ResponseAuth> response) {
                if (response.isSuccessful()){
                    if (!response.body().getToken().equals(null)) {
                        sessionManager.createLoginSession(response.body().getValue(), response.body().getToken());
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(context, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseAuth> call, Throwable t) {

            }
        });



    }



}
