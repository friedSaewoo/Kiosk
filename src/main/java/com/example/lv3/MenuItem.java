package com.example.lv3;

public class MenuItem {
    private final String menuName;
    private final String menuPrice;
    private final String menuInfo;

    public MenuItem(String menuName, String menuPrice, String menuInfo) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public String getMenuInfo() {
        return menuInfo;
    }
}
