package com.tajir.model;

public class Item {

    private String item_title,number_item;
    private Boolean enable;

    public Item(String item_title, String number_item, Boolean enable){
        this.item_title =  item_title;
        this.number_item =  number_item;
        this.enable = enable;
    }

    public String getItem_title() {
        return item_title;
    }

    public void setItem_title(String item_title) {
        this.item_title = item_title;
    }

    public String getNumber_item() {
        return number_item;
    }

    public void setNumber_item(String number_item) {
        this.number_item = number_item;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
