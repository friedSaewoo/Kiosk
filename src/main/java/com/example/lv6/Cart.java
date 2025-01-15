package com.example.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.lv6.InputInteger.inputInteger;

public class Cart {
    private final List<CartItem> cartItemList;

    public Cart() {
        this.cartItemList = new ArrayList<>();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void addMenuToCart(MenuItem menuItem) {
        Optional<CartItem> cartItemOptional = cartItemList.stream()
                .filter(item -> item.getMenuItem().equals(menuItem))
                .findFirst();

        if (cartItemOptional.isPresent()) {
            cartItemOptional.get().addQuantity();
        } else {
            cartItemList.add(new CartItem(menuItem));
        }
    }

    public void showCart() {
        System.out.println("\n[ Orders ]");
        for (CartItem cartItem : cartItemList) {
            System.out.printf("%-15s", cartItem.getMenuItem().getMenuName());
            System.out.printf("| w %-5s| ", cartItem.getMenuItem().getMenuPrice());
            System.out.printf("수량 : %-5s| ", cartItem.getQuantity());
            System.out.println(cartItem.getMenuItem().getMenuInfo());
        }
        System.out.println("\n[ Total ]");
        double sumPrice = sumPrice();
        System.out.printf("w %.1f \n\n", sumPrice);
        System.out.println("1. 주문      2. 메뉴판");
        while (true) {
            int cartOption = inputInteger();
            if(cartOption == 1){
                System.out.printf("주문이 완료되었습니다. 금액은 w %.1f 입니다.\n",sumPrice);
                cleanCart();
                break;
            } else if (cartOption == 2) {
                break;
            }else{
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            }
        }
    }

    public double sumPrice() {
        double sum = 0.0;
        for (CartItem cartItem : cartItemList) {
            sum += cartItem.getMenuItem().getMenuPrice() * cartItem.getQuantity();
        }
        return sum;
    }

    public void cleanCart() {
        cartItemList.clear();
    }
    public boolean cartIsEmpty(){
        return cartItemList.isEmpty();
    }
}
