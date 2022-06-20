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

            //m_tab_layout.addTab(m_tab_layout.newTab().setText(buildCategoriList().size()));
            //m_tab_layout.addTab(m_tab_layout.newTab().setText(jenisBahanList.get(i).getNama()));
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

    private List<Category> buildCategoriList() {
        List<Category> itemList = new ArrayList<>();
        for (int i=0; i<10; i++) {
            Category item = new Category("Kategori("+i+")", buildItemList());
            itemList.add(item);
        }
        return itemList;
    }

    private List<Item> buildItemList() {
        List<Item> subItemList = new ArrayList<>();
        for (int i=0; i<3; i++) {
            Boolean enable =  true;
            if (i == 0){
                enable = false;
            }
            Item item = new Item("Apple Phone "+i,  getResources().getString(R.string.app_name)+" "+i,enable);
            subItemList.add(item);
        }
        return subItemList;
    }

    void createmenu() {
        mainMenus.clear();
       // int jml = countcart(context);
        mainMenus.add(0, new MainMenu("Jual Sampah", R.drawable.ic_settings, 0));
        mainMenus.add(1, new MainMenu("Drop Box", R.drawable.ic_settings, 0));
        mainMenus.add(2, new MainMenu("Pulsa", R.drawable.ic_settings, 0));
        mainMenus.add(3, new MainMenu("Paket Data", R.drawable.ic_settings, 0));
        mainMenus.add(4, new MainMenu("BPJS", R.drawable.ic_settings, 0));
        mainMenus.add(5, new MainMenu("Listrik", R.drawable.ic_settings, 0));
        mainMenus.add(6, new MainMenu("Token Listrik", R.drawable.ic_settings, 0));
        mainMenus.add(7, new MainMenu("Lainnya", R.drawable.ic_settings, 0));

        mainMenuAdapter.notifyDataSetChanged();

    }


}