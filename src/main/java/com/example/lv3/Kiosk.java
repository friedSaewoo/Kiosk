package com.example.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner sc = new Scanner(System.in);
    List<MenuItem> menuList;
    int menu;

    // 기본 생성자, setMenu로 리스트에 메뉴 추가
    public Kiosk() {
        this.menuList = new ArrayList<>();
        setMenu();
    }
    
    // 키오스크 시작 메서드
    public void start() {
        while (true) {
            showMenuList();
            menu = inputInteger();

            if (menu == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }
            showMenuInfo(menu);
        }
    }
    // 리스트에 메뉴를 추가하는 메서드
    private void setMenu() {
        menuList.add(new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"));
    }

    // 메뉴 리스트를 출력하는 메서드
    private void showMenuList() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menuList.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-15s", menuList.get(i).getMenuName());
            System.out.printf("| w %-5s| ", menuList.get(i).getMenuPrice());
            System.out.println(menuList.get(i).getMenuInfo());
        }
        System.out.println("0. 종료");
    }

    // 정수를 입력받는 메서드
    private int inputInteger() {
        int input = 0;
        while (true) {
            try {
                System.out.print("입력 : ");
                input = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
                continue;
            }
            if (input >= 0) {
                return input;
            } else {
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            }
        }
    }
    // 선택된 메뉴를 출력하는 메서드
    private void showMenuInfo (int menu){
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
