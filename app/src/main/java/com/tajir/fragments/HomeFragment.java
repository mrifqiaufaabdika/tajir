package com.tajir.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.tajir.R;
import com.tajir.adapters.MainMenuAdapter;
import com.tajir.model.MainMenu;
import com.tajir.utils.MyGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {

    private MainMenuAdapter mainMenuAdapter = null;
    Context context;
    private List<MainMenu> mainMenus = new ArrayList<>();

    @BindView(R.id.gdv_menu)
    MyGridView grid_main;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //return inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this, view);
        context = getContext();

        mainMenuAdapter = new MainMenuAdapter(context, mainMenus);
        grid_main.setAdapter(mainMenuAdapter);
        createmenu();


        return view;
    }

    void createmenu() {
        mainMenus.clear();
        // int jml = countcart(context);
        mainMenus.add(0, new MainMenu("Kelola Produk", R.drawable.ic_kelola, 0));
        mainMenus.add(1, new MainMenu("Pegawai", R.drawable.ic_user_1, 0));
        mainMenus.add(2, new MainMenu("Voucher", R.drawable.ic_ticket_1, 0));
        mainMenus.add(3, new MainMenu("Laporan", R.drawable.ic_book_alt_1, 0));
        mainMenus.add(4, new MainMenu("Pelanggan", R.drawable.ic_pelanggan, 0));
        mainMenus.add(5, new MainMenu("Panduan", R.drawable.ic_interrogation_1, 0));
        mainMenus.add(6, new MainMenu("Absensi", R.drawable.ic_calendar_1, 0));
        mainMenus.add(7, new MainMenu("Lihat Semua", R.drawable.ic_coffee, 0));

        mainMenuAdapter.notifyDataSetChanged();

    }
}