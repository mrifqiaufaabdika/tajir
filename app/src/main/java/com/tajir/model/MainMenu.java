package com.tajir.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainMenu {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("icon")
    @Expose
    private int icon;
    @SerializedName("count_cart")
    @Expose
    private int count_cart;

    public MainMenu(String title, int icon, int count_cart){
        this.title= title;
        this.icon= icon;
        this.count_cart= count_cart;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getCount_cart() {
        return count_cart;
    }

    public void setCount_cart(int count_cart) {
        this.count_cart = count_cart;
    }
}
