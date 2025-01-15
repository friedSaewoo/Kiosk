package com.example.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.example.lv6.InputInteger.inputInteger;

public class Kiosk {
    private final List<Menu> menu;
    private final Cart cart = new Cart();
    private final Scanner sc = new Scanner(System.in);

    public Kiosk() {
        this.menu = new ArrayList<>();
    }



    // 키오스크 실행
    public void start() {
        boolean cartInMenu = false; // 장바구니에 물건이 있는지 여부 확인
        while (true) {
            showCategory(); // 카테고리 출력
            if (cartInMenu) {
                System.out.println("\n[ Order Menu ]");
                System.out.println("4. Orders");
                System.out.println("5. Cancel");
            }
            System.out.println("0. 종료");
            // 카테고리 선택
            int categoryOption = inputInteger();
            
            // 올바른 카테고리를 입력할때까지 반복
            if (categoryOption == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }else if((categoryOption == 4 || categoryOption == 5) && cartInMenu ){

                    if(categoryOption == 4){
                        cart.showCart();
                        cartInMenu = !cart.cartIsEmpty();
                    }else{
                        cart.cleanCart();
                        cartInMenu=false;
                    }

            } else if (categoryOption > menu.size()) {
                System.out.println();
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            } else {
                // 올바른 메뉴를 입력할때까지 반복
                while (true) {
                    // 메뉴 선택
                    menu.get(categoryOption - 1).showMenuList();
                    int menuOption = inputInteger();
                    if (menuOption == 0) {
                        break;
                    } else if (menuOption > menu.get(categoryOption - 1).getMenuList().size()) { // 메뉴 리스트 사이즈로 범위 제한
                        System.out.println("\n올바른 선택지를 입력하세요!!\n");
                    } else {
                        menu.get(categoryOption - 1).showMenuInfo(menuOption);
                        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                        System.out.println("1. 확인            2. 취소");

                        // 선택한 메뉴 정보 확인 후 구매/취소 선택
                        while (true) {
                            int buyOption = inputInteger();
                            if(buyOption == 1){
                                cart.addMenuToCart(menu.get(categoryOption-1).getMenuList().get(menuOption-1));
                                if (!cartInMenu){
                                    cartInMenu=true;
                                }
                                break;
                            }else if (buyOption >=3){
                                System.out.println("\n올바른 선택지를 입력하세요!!\n");
                            }else{
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    // 카테고리를 출력해주는 첫 메뉴
    private void showCategory() {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menu.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-15s", menu.get(i).getCategory());
            System.out.println();
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

}
