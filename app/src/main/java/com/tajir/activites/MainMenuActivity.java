package com.tajir.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

//import io.github.douglasjunior.androidSimpleTooltip.OverlayView;
//import io.github.douglasjunior.androidSimpleTooltip.SimpleTooltip;
import com.tajir.R;
import com.tajir.databinding.ActivityMainBinding;
import com.tajir.fragments.AddFragment;
import com.tajir.fragments.HomeFragment;

public class MainMenuActivity extends AppCompatActivity {

    private Context context;
    private ActivityMainBinding binding;



    /*
    declaretion for fragments
     */
    final HomeFragment homeFragment = new HomeFragment();
    final AddFragment listFragment = new AddFragment();
    final AddFragment addFragment = new AddFragment();
    final AddFragment campaignFragment = new AddFragment();
    final AddFragment menuFragment =  new AddFragment();

    /*
    set started fragment
     */
    Fragment activeFragment = homeFragment;
    FragmentManager fragmentManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        context = this;
        fragmentManager = getSupportFragmentManager();

        binding.navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.action_home:
                    if (fragmentManager.findFragmentByTag("HomeFragment")==null){
                        fragmentManager.beginTransaction().add(R.id.container, homeFragment, "HomeFragment").commit();
                    }
                    fragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit();
                    activeFragment = homeFragment;
                    updateStatusBarColor(getResources().getColor(R.color.start_color));
                    return true;

                case R.id.action_list:
                    if (fragmentManager.findFragmentByTag("ListFragment") == null){
                        fragmentManager.beginTransaction().add(R.id.container, listFragment, "ListFragment").commit();
                    }
                    fragmentManager.beginTransaction().hide(activeFragment).show(listFragment).commit();
                    activeFragment = listFragment;
                    updateStatusBarColor(getResources().getColor(R.color.white));
                    return true;
                case R.id.action_campaign:
                    if (fragmentManager.findFragmentByTag("CampaignFragment") == null){
                        fragmentManager.beginTransaction().add(R.id.container, campaignFragment, "CampaignFragment").commit();
                    }
                    fragmentManager.beginTransaction().hide(activeFragment).show(campaignFragment).commit();
                    activeFragment = campaignFragment;
                    updateStatusBarColor(getResources().getColor(R.color.white));
                    return true;
                case R.id.action_menu:
                    if (fragmentManager.findFragmentByTag("MenuFragment") == null){
                        fragmentManager.beginTransaction().add(R.id.container, menuFragment, "MenuFragment").commit();
                    }
                    fragmentManager.beginTransaction().hide(activeFragment).show(menuFragment).commit();
                    activeFragment = menuFragment;
                    updateStatusBarColor(getResources().getColor(R.color.white));
                    return true;
                case R.id.action_add:
                    startActivity(new Intent(view.getContext(), AddFragment.class));
                    return true;
                default:
                    return false;
            }
        });

        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(), TransaksiActivity.class));

            }
        });

        /*
        Load first fragment
         */
        fragmentManager.beginTransaction().add(R.id.container, homeFragment, "HomeFragment").commit();
        binding.navigation.getMenu().findItem(R.id.action_home).setChecked(true);
        updateStatusBarColor(getResources().getColor(R.color.start_color));


    }


    public void updateStatusBarColor(int color) {// Color must be in hexadecimal fromat
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            //window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility()| View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
            window.getDecorView().setSystemUiVisibility(0);

        }
    }

}