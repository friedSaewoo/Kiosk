package com.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuList = new ArrayList<>();
        MenuItem menu1 = new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menu2 = new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menu3 = new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menu4 = new MenuItem("Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거");

        menuList.add(menu1);
        menuList.add(menu2);
        menuList.add(menu3);
        menuList.add(menu4);

        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = 0;
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.print(i + 1 + ". ");
                System.out.printf("%-15s", menuList.get(i).getMenuName());
                System.out.printf("| w %-5s|", menuList.get(i).getMenuPrice());
                System.out.println(menuList.get(i).getMenuInfo());
            }
            System.out.println("0. 종료");

            try {
                a = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("\n올바른 선택지를 입력하세요 !!\n");
                continue;
            }

            if(a == 0){
                System.out.println("키오스크를 종료합니다.");
                break;
            } else if (a < 0 ) {
                System.out.println("\n올바른 선택지를 입력하세요 !!\n");
            }else{
                try{
                    System.out.println("\n***************************************");
                    System.out.println("메뉴 명 :" + menuList.get(a-1).getMenuName());
                    System.out.println("가격 :" + menuList.get(a-1).getMenuPrice());
                    System.out.println("정보 :"+ menuList.get(a-1).getMenuInfo());
                    System.out.println("***************************************\n");
                }catch (IndexOutOfBoundsException e){
                    System.out.println("\n올바른 선택지를 입력하세요 !!\n");
                }
            }
        }

    }
}
