package com.example.lv1;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        menu.add("ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menu.add("SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        menu.add("Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        menu.add("Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");

        while(true){
            int a = 0;
            System.out.println("[ SHAKESHACK MENU ]");
            for (int i = 0 ;i< menu.size();i++){
                System.out.println(i+1+". "+ menu.get(i));
            }
            System.out.println("0. 종료       | 종료");
            try {
                System.out.print("\n무엇을 하시겠습니까 ? : ");
                a = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println("올바른 선택지를 골라주세요!!");
                continue;
            }
            if(a == 0){
                System.out.println("키오스크를 종료합니다.");
                break;
            }else if(a <=menu.size()) {
                System.out.println("**********************************************************************");
                System.out.println("선택하신 메뉴 : "+menu.get(a-1));
                System.out.println("**********************************************************************");
            }else{
                System.out.println("올바른 선택지를 골라주세요!!");
            }
        }
    }
}