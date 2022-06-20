package com.tajir.model;

import java.util.List;

public class Category {

    private String title;
    private List<Item> itemList;

    private Boolean expanded = false;

    public Category(String title, List<Item> itemList){
        this.title =  title;
        this.itemList = itemList;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
