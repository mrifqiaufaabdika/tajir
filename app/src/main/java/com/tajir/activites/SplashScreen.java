package com.tajir.activites;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tajir.BuildConfig;
import com.tajir.databinding.ActivitySplashBinding;
import com.tajir.utils.SessionManager;
import com.tajir.activites.MainMenuActivity;


public class SplashScreen extends AppCompatActivity {

    private SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.txtVersion.setText(BuildConfig.VERSION_NAME); // set name version apk

        sessionManager = new SessionManager(this);

        final Handler handler = new Handler();
        handler.postDelayed(this::checkSessionLogin, 3000L);//3000L = 3 detik
    }

    /**
     * this method will be chek for session login user
     */
    private void checkSessionLogin() {
        Intent intent;

        if (!sessionManager.isLoggedIn()){
            intent = new Intent(getApplicationContext(), AuthActivity.class);
        }else {
            intent = new Intent(getApplicationContext(), MainMenuActivity.class);
        }


        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        this.finish();
    }
}
