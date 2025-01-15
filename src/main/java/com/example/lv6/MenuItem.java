package com.example.lv6;

public class MenuItem {
    private final String menuName;
    private final double menuPrice;
    private final String menuInfo;

    public MenuItem(String menuName, double menuPrice, String menuInfo) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public String getMenuInfo() {
        return menuInfo;
    }
}
