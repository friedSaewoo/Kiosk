package com.example.lv6;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.lv6.InputInteger.inputInteger;
import static com.example.lv6.InputInteger.sc;


public class Cart {
    private final List<CartItem> cartItemList;
    private final Discount[] discount = Discount.values();
    double sumPrice;

    public Cart() {
        this.cartItemList = new ArrayList<>();
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }
    // 선택한 메뉴를 장바구니에 추가하는 메서드
    public void addMenuToCart(MenuItem menuItem) {
        // 선택한 메뉴가 장바구니에 이미 있으면 수량 증가, 없을시 객체를 새로 생성해 장바구니에 추가
        Optional<CartItem> cartItemOptional = cartItemList.stream()
                .filter(item -> item.getMenuItem().equals(menuItem))
                .findFirst();
        if (cartItemOptional.isPresent()) {
            cartItemOptional.get().addQuantity();
        } else {
            cartItemList.add(new CartItem(menuItem));
        }
    }
    // 장바구니 내역 출력 메서드
    public void showCart() {
        System.out.println("\n[ Orders ]");
        for (CartItem cartItem : cartItemList) {
            System.out.printf("%-15s", cartItem.getMenuItem().getMenuName());
            System.out.printf("| w %-5s| ", cartItem.getMenuItem().getMenuPrice());
            System.out.printf("수량 : %-5s| ", cartItem.getQuantity());
            System.out.println(cartItem.getMenuItem().getMenuInfo());
        }
        sumPrice = sumPrice();
        System.out.println("\n[ Total ]");
        System.out.printf("w %.1f \n\n", sumPrice);
        buyItemsFromCart();
    }
    // 장바구니의 아이템을 구매하는 메서드
    private void buyItemsFromCart(){
        while (true) {
            System.out.println("1. 주문      2. 메뉴판      3. 메뉴삭제");
            int cartOption = inputInteger();
            if (cartOption == 1) {
                int discountPer = selectDiscount();
                System.out.printf("주문이 완료되었습니다. 금액은 w %.1f 입니다.\n", sumPrice-(sumPrice*(discountPer/100.0)));
                cleanCart();
                sumPrice = 0;
                break;
            } else if (cartOption == 2) {
                break;
            } else if(cartOption == 3){
                deleteFromCart();
                break;
            } else {
                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            }
        }
    }
    // 장바구니 아이템 삭제 메서드
    private void deleteFromCart(){
        System.out.print("장바구니에서 삭제할 메뉴입력 : ");
        String deleteMenu = sc.nextLine();
        Optional<CartItem> cartOptional = cartItemList.stream()
                .filter(cart -> cart.getMenuItem().getMenuName().equals(deleteMenu))
                .findFirst();

        if(cartOptional.isPresent()){
            cartItemList.remove(cartOptional.get());
            System.out.println("\n장바구니에서 해당 메뉴를 삭제했습니다.");
        }else{
            System.out.println("\n장바구니에 해당 메뉴가 없습니다.");
        }
    }
    // 할인율을 받아오는 메서드
    private int selectDiscount(){
        System.out.println("\n할인정보를 입력해주세요");
        for(int i=0 ; i<discount.length;i++){
            System.out.println(i+1+". "+discount[i].getName());
        }
        while(true){
            int discountOption = inputInteger();
            if(discountOption>discount.length){

                System.out.println("\n올바른 선택지를 입력하세요!!\n");
            }else{
                return discount[discountOption-1].getDiscountRate();
            }
        }

    }
    // 장바구니 총액 반환하는 메서드
    private double sumPrice() {
        double sum = 0.0;
        for (CartItem cartItem : cartItemList) {
            sum += cartItem.getMenuItem().getMenuPrice() * cartItem.getQuantity();
        }
        return sum;
    }
    // 장바구니 초기화 메서드
    public void cleanCart() {
        cartItemList.clear();
    }
    // 장바구니 비었는지 확인하는 메서드
    public boolean cartIsEmpty() {
        return cartItemList.isEmpty();
    }
}
