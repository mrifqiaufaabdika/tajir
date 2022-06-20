package com.tajir.activites;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.tajir.R;
import com.tajir.adapters.MainMenuAdapter;
import com.tajir.model.Category;
import com.tajir.model.Item;
import com.tajir.model.MainMenu;
import com.tajir.utils.MyGridView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TransaksiActivity extends AppCompatActivity {

    private MainMenuAdapter mainMenuAdapter = null;
    Context context;
    private List<MainMenu> mainMenus = new ArrayList<>();

    @BindView(R.id.gdv_menu)
    MyGridView grid_main;
    @BindView(R.id.tabLayout)
    TabLayout m_tab_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);
        ButterKnife.bind(this);
        context = getApplicationContext();

        mainMenuAdapter = new MainMenuAdapter(context, mainMenus);
        grid_main.setAdapter(mainMenuAdapter);
        createmenu();

        for (int i = 0; i < 5; i++) {
            m_tab_layout.addTab(m_tab_layout.newTab().setText("Kategori"));
        }

        for (int i = 0; i < m_tab_layout.getTabCount() - 1; i++) {
            View tab = ((ViewGroup) m_tab_layout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(0, 0, 30, 0);
            tab.requestLayout();
        }

        LinearLayout tabLayout = (LinearLayout)((ViewGroup) m_tab_layout.getChildAt(0)).getChildAt(0);



    }


    void createmenu() {
        mainMenus.clear();
       // int jml = countcart(context);
        mainMenus.add(0, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(1, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(2, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(3, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(4, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(5, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(6, new MainMenu("Americano", R.drawable.ic_coffee, 0));
        mainMenus.add(7, new MainMenu("Americano", R.drawable.ic_coffee, 0));

        mainMenuAdapter.notifyDataSetChanged();

    }


}