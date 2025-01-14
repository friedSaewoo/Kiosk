package com.example.lv4_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menu;
    private final Scanner sc = new Scanner(System.in);

    public Kiosk() {
        this.menu = new ArrayList<>();
    }
    // 카테고리를 출력해주는 첫 메뉴
    private void showCategory() {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < menu.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-15s", menu.get(i).getCategory());
            System.out.println();
        }
        System.out.println("0. 종료");
    }

    // 키오스크 실행
    public void start() {
        while (true) {
            showCategory(); // 카테고리 출력
            int categoryOption = inputInteger();

            if (categoryOption == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }else if(categoryOption > menu.size()){
                System.out.println();
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            }else{
                while (true) {
                    menu.get(categoryOption - 1).showMenuList();
                    int menuOption = inputInteger();
                    if (menuOption == 0) {
                        break;
                    } else if (menuOption > menu.get(categoryOption-1).getMenuList().size()) {
                        System.out.println("\n올바른 선택지를 입력하세요!!\n");
                    } else{
                        menu.get(categoryOption-1).showMenuInfo(menuOption);
                      break;
                    }
                }
            }
        }
    }

    // category, menuItem 추가 메서드
    public void addMenu(String categoryName, MenuItem menuItem) {
        // 입력한 카테고리가 이미 존재하는지 확인
        Optional<Menu> menuOptional = menu.stream()
                .filter(menu -> menu.getCategory().equals(categoryName))
                .findFirst();
        // 카테고리가 이미 존재한다면, 해당 카테고리에 menuItem 추가
        if (menuOptional.isPresent()) {
            menuOptional.get().addMenuItem(menuItem);
        } else {
            // 카테고리가 존재하지 않으면 카테고리(Menu) 객체를 새로 생성하고 해당 카테고리에 menuItem추가
            Menu newMenu = new Menu(categoryName);
            newMenu.addMenuItem(menuItem);
            menu.add(newMenu);
        }
    }
    
    // 정수를 입력받는 메서드
    private int inputInteger() {
        int input;
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
}
