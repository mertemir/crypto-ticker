package com.example.basics.cryptoticker.model;

public class ListItem {
    public ListItem(String name, String price, int icon) {
        this.name = name;
        this.price = price;
        this.icon = icon;
    }

    private String name, price;
    private int icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
