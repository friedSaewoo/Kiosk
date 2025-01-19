package com.example.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.lv6.InputInteger.inputInteger;

public class Kiosk {
    private final List<Menu> menu;
    private final Cart cart = new Cart();
    private boolean cartInMenu = false;

    public Kiosk() {
        this.menu = new ArrayList<>();
        constructMenu();
    }

    private void constructMenu() {
        // 메뉴추가
        // 버거
        addMenu("Burgers", new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        addMenu("Burgers", new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        addMenu("Burgers", new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        addMenu("Burgers", new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        // 드링크
        addMenu("Drinks", new MenuItem("Coke", 2.5, "콜라, 탄산음료"));
        addMenu("Drinks", new MenuItem("Sprite", 2.5, "청량한 레몬향의 탄산음료"));
        addMenu("Drinks", new MenuItem("Lemonade", 3.0, "상큼한 레몬 주스"));
        addMenu("Drinks", new MenuItem("Iced Tea", 3.2, "시원한 아이스 티"));
        // 디저트
        addMenu("Desserts", new MenuItem("Milkshake", 5.5, "바닐라 아이스크림과 우유로 만든 밀크쉐이크"));
        addMenu("Desserts", new MenuItem("Chocolate Cake", 4.0, "진한 초콜릿 케이크"));
        addMenu("Desserts", new MenuItem("Cheesecake", 4.5, "부드럽고 고소한 치즈케이크"));
        addMenu("Desserts", new MenuItem("Apple Pie", 3.5, "따뜻한 애플 파이"));
    }

    // 키오스크 실행
    public void start() {
        System.out.println("키오스크 시작");
        while (true) {
            showCategory(cartInMenu); // 카테고리 출력
            // 카테고리 선택
            int categoryOption = inputInteger();
            if (categoryOption == 0) {
                System.out.println("키오스크를 종료합니다.");
                break;
            }
            handleCategorySelection(categoryOption);
        }
    }

    // 장바구니가 비었는지 여부에 따라 선택지를 출력해주는 메서드
    private void handleCategorySelection(int categoryOption) {
        if ((categoryOption == 4 || categoryOption == 5) && cartInMenu) {

            if (categoryOption == 4) {
                cart.showCart();
                cartInMenu = !cart.cartIsEmpty();
            } else {
                cart.cleanCart();
                cartInMenu = false;
            }
        } else if (categoryOption > menu.size()) {
            System.out.println("\n올바른 선택지를 입력하세요!!\n");
        } else {
            handleMenuSelection(categoryOption);
        }
    }
    // 메뉴 관리 메서드
    private void handleMenuSelection(int categoryOption) {
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
                buyMenu(categoryOption, menuOption);
                break;
            }
        }
    }
    // 선택한 메뉴 구매 메서드
    private void buyMenu(int categoryOption, int menuOption) {
        menu.get(categoryOption - 1).showMenuInfo(menuOption);
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인            2. 취소");

        // 선택한 메뉴 정보 확인 후 구매/취소 선택
        while (true) {
            int buyOption = inputInteger();
            if (buyOption == 1) {
                cart.addMenuToCart(menu.get(categoryOption - 1).getMenuList().get(menuOption - 1));
                if (!cartInMenu) {
                    cartInMenu = true;
                }
                break;
            } else if (buyOption >= 3) {
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            } else {
                break;
            }
        }
    }

    // 카테고리를 출력해주는 첫 메뉴
    private void showCategory(boolean cartInMenu) {
        System.out.println("\n[ MAIN MENU ]");
        for (int i = 0; i < menu.size(); i++) {
            System.out.print(i + 1 + ". ");
            System.out.printf("%-15s", menu.get(i).getCategory());
            System.out.println();
        }
        if (cartInMenu) {
            System.out.println("\n[ Order Menu ]");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
        }
        System.out.println("0. 종료");
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
}
