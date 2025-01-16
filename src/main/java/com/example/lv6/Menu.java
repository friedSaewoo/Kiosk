package com.example.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Menu {
    private final String category;
    private final List<MenuItem> menuList;
    
    // 카테고리를 매개변수로 받고, List는 초기화만 해주는 생성자, List는 메서드로 추가
    public Menu(String category) {
        this.category = category;
        this.menuList = new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }
    // menuItem을 추가해주는 메서드
    public void addMenuItem(MenuItem menuItem){
        this.menuList.add(menuItem);
    }

    // 카테고리별 메뉴 리스트 출력
    public void showMenuList() {
        System.out.println("\n[ SHAKESHACK MENU ]");
        IntStream.range(0, menuList.size())
                .forEach(i -> {
                    MenuItem menuItem = menuList.get(i);
                    System.out.printf("%d. %-15s| w %-5s| %s\n",
                            i + 1,
                            menuItem.getMenuName(),
                            menuItem.getMenuPrice(),
                            menuItem.getMenuInfo());
                });
        System.out.println("0. 뒤로가기");
    }

    // 선택한 메뉴 정보를 출력하는 메서드
    public void showMenuInfo (int menu){
        try {
            String name = menuList.get(menu-1).getMenuName();
            double price = menuList.get(menu - 1).getMenuPrice();
            String info = menuList.get(menu - 1).getMenuInfo();
            System.out.println("\n[ Orders ]");
            System.out.printf("%-15s", name);
            System.out.printf("| w %-5s| ", price);
            System.out.println(info);
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("\n올바른 선택지를 입력하세요!!\n");
        }
    }
}
