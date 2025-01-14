package com.example.lv4_5;

public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        // 메뉴추가
        // 버거
        kiosk.addMenu("Burgers", new MenuItem("ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        kiosk.addMenu("Burgers", new MenuItem("SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        kiosk.addMenu("Burgers", new MenuItem("Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        kiosk.addMenu("Burgers", new MenuItem("Hamburger", "5.4 ", "비프패티를 기반으로 야채가 들어간 기본버거"));
        // 드링크
        kiosk.addMenu("Drinks", new MenuItem("Coke", "2.5", "콜라, 탄산음료"));
        kiosk.addMenu("Drinks", new MenuItem("Sprite", "2.5", "청량한 레몬향의 탄산음료"));
        kiosk.addMenu("Drinks", new MenuItem("Lemonade", "3.0", "상큼한 레몬 주스"));
        kiosk.addMenu("Drinks", new MenuItem("Iced Tea", "3.2", "시원한 아이스 티"));
        // 디저트
        kiosk.addMenu("Desserts", new MenuItem("Milkshake", "5.5", "바닐라 아이스크림과 우유로 만든 밀크쉐이크"));
        kiosk.addMenu("Desserts", new MenuItem("Chocolate Cake", "4.0", "진한 초콜릿 케이크"));
        kiosk.addMenu("Desserts", new MenuItem("Cheesecake", "4.5", "부드럽고 고소한 치즈케이크"));
        kiosk.addMenu("Desserts", new MenuItem("Apple Pie", "3.5", "따뜻한 애플 파이"));

        kiosk.start();

    }
}
