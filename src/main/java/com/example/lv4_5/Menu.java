package com.example.lv4_5;

import java.util.ArrayList;
import java.util.List;

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
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-15s", menuList.get(i).getMenuName());
            System.out.printf("| w %-5s| ", menuList.get(i).getMenuPrice());
            System.out.println(menuList.get(i).getMenuInfo());
        }
        System.out.println("0. 뒤로가기");
    }

    // 선택한 메뉴 정보를 출력하는 메서드
    public void showMenuInfo (int menu){
        try {
            String name = menuList.get(menu-1).getMenuName();
            String age = menuList.get(menu - 1).getMenuPrice();
            String info = menuList.get(menu - 1).getMenuInfo();
            System.out.println("\n***************************************");
            System.out.println("메뉴 명 :" + name);
            System.out.println("가격 :" + age);
            System.out.println("정보 :" + info);
            System.out.println("***************************************\n");
        } catch (IndexOutOfBoundsException ioe) {
            System.out.println("\n올바른 선택지를 입력하세요!!\n");
        }
    }
}
