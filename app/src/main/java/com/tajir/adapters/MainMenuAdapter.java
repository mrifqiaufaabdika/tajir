package com.tajir.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tajir.activites.SplashScreen;
import com.tajir.activites.TransaksiActivity;
import com.tajir.model.MainMenu;
import com.tajir.R;

import java.util.List;

public class MainMenuAdapter extends BaseAdapter {

    private Context mContex;
    List<MainMenu>mainMenus;
    TextView badge;

    public MainMenuAdapter(Context mContex, List<MainMenu> mainMenus) {
        this.mContex = mContex;
        this.mainMenus = mainMenus;
    }


    @Override
    public int getCount() {
        return mainMenus.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContex
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater inf = LayoutInflater.from(mContex);

        if (convertView == null) {

            grid = new View(mContex);
            grid = inf.inflate(R.layout.single_grid_produk, null);
            TextView textView = (TextView) grid.findViewById(R.id.txt_label);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imv_label);
            badge = (TextView) grid.findViewById(R.id.imv_badge_info);

            MainMenu mainMenu = mainMenus.get(position);

            textView.setText(mainMenu.getTitle());
            if (mainMenu.getCount_cart()<=0) {
                badge.setVisibility(View.GONE);
            }else {
                badge.setText(String.valueOf(mainMenu.getCount_cart()));
                badge.setVisibility(View.VISIBLE);
            }

            grid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (position == 0){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        mContex.startActivity(intent);
                    } else if (position ==1){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        mContex.startActivity(intent);
                    } else if (position == 2){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        intent.putExtra("type", "pulsa");
                        intent.putExtra("title",  "Pulsa Prabayar");
                        intent.putExtra("banner_code", "6");
                        mContex.startActivity(intent);
                    }else if (position == 3){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        intent.putExtra("type", "data");
                        intent.putExtra("title",  "Paket Data");
                        intent.putExtra("banner_code", "6");
                        mContex.startActivity(intent);
                    }else if (position == 4){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        intent.putExtra("type", "bpjs_pasca");
                        intent.putExtra("title",  "BPJS Kesehatan");
                        intent.putExtra("banner_code", "11");

                        mContex.startActivity(intent);
                    }else if (position == 5){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        intent.putExtra("type", "pln_pasca");
                        intent.putExtra("title",  "Tagihan Listrik");
                        intent.putExtra("banner_code", "8");
                        mContex.startActivity(intent);
                    }else if (position == 6){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        intent.putExtra("type", "listriktoken");
                        intent.putExtra("title",  "Token Listrik");
                        intent.putExtra("banner_code", "8");
                        mContex.startActivity(intent);
                    }
                    else if (position == (mainMenus.size()-1)){
                        Intent intent = new Intent(mContex, SplashScreen.class);
                        mContex.startActivity(intent);
                    }
                }
            });
            imageView.setImageResource(mainMenu.getIcon());
        } else {
            grid = (View) convertView;
        }

        return grid;
    }





}
