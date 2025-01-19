# Kiosk
## Lv 1. 기본적인 키오스크 프로그래밍
- Scanner를 이용해 메뉴 출력하기
> 출력
<pre><code>
[ SHAKESHACK MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 종료       | 종료

무엇을 하시겠습니까 ? : 0
키오스크를 종료합니다.

</code></pre>

## Lv 2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
- MenuItem 클래스를 생성해 개별 음식 항목 관리
>출력
<pre><code>
  ***************************************
메뉴 명 :ShackBurger
가격 :6.9
정보 :토마토, 양상추, 쉑소스가 토핑된 치즈버거
***************************************

[ SHAKESHACK MENU ]
1. ShackBurger    | w 6.9  |토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack     | w 8.9  |베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger   | w 6.9  |포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger      | w 5.4  |비프패티를 기반으로 야채가 들어간 기본버거
0. 종료
0
키오스크를 종료합니다.
</code></pre>
## Lv 3. 객체 지향 설계를 적용해 순서 제어를 클래스로 관리하기
- 프로그램 메뉴를 관리하고 전체 순서를 제어하는 Kiosk 클래스 생성
>출력
<pre><code>
    ***************************************
메뉴 명 :ShackBurger
가격 :6.9
정보 :토마토, 양상추, 쉑소스가 토핑된 치즈버거
***************************************

[ SHAKESHACK MENU ]
1. ShackBurger    | w 6.9  |토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack     | w 8.9  |베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger   | w 6.9  |포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger      | w 5.4  |비프패티를 기반으로 야채가 들어간 기본버거
0. 종료
0
키오스크를 종료합니다.
</code></pre>
## Lv 4-5. 객체 지향 설계를 적용해 음식 메뉴와 주문 내역을 클래스 기반으로 관리하기, 캡슐화 적용하기
- MenuItem을 관리하는 Menu클래스 생성
- 카테고리를 추가, 여러 메뉴를 추가할 수 있도록 변경
- 각 클래스의 필드에 직접 접근하지 못하도록 설정
> 출력
<pre><code>
  [ SHAKESHACK MENU ]
1. Burgers        
2. Drinks         
3. Desserts       
0. 종료
입력 : 1
[ SHAKESHACK MENU ]
1. ShackBurger    | w 6.9  | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack     | w 8.9  | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger   | w 6.9  | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger      | w 5.4  | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
입력 : 1

***************************************
메뉴 명 :ShackBurger
가격 :6.9
정보 :토마토, 양상추, 쉑소스가 토핑된 치즈버거
***************************************
</code></pre>

## Lv 6. 장바구니 및 구매하기 기능을 추가 및 Enum & Stream을 활용하여 장바구니 관리하기
- 선택한 메뉴를 장바구니에 추가할 수 있는 기능 제공 및 동적조회 가능하도록 구현
> 출력
<pre><code>
  [ SHAKESHACK MENU ]
1. Milkshake      | w 5.5  | 바닐라 아이스크림과 우유로 만든 밀크쉐이크
2. Chocolate Cake | w 4.0  | 진한 초콜릿 케이크
3. Cheesecake     | w 4.5  | 부드럽고 고소한 치즈케이크
4. Apple Pie      | w 3.5  | 따뜻한 애플 파이
0. 뒤로가기
입력 : 4

[ Orders ]
Apple Pie      | w 3.5  | 따뜻한 애플 파이
위 메뉴를 장바구니에 추가하시겠습니까?
1. 확인            2. 취소
입력 : 1

[ MAIN MENU ]
1. Burgers        
2. Drinks         
3. Desserts       

[ Order Menu ]
4. Orders
5. Cancel
0. 종료
입력 : 4

[ Orders ]
Apple Pie      | w 3.5  | 수량 : 1    | 따뜻한 애플 파이

[ Total ]
w 3.5 

1. 주문      2. 메뉴판      3. 메뉴삭제
입력 : 
</code></pre>
- 주문을 선택할시 총 금액을 계산하고 주문하기를 누르면 장바구니 초기화
> 출력
<pre><code>
  [ Orders ]
ShackBurger    | w 6.9  | 수량 : 1    | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
Chocolate Cake | w 4.0  | 수량 : 1    | 진한 초콜릿 케이크

[ Total ]
w 10.9 

1. 주문      2. 메뉴판      3. 메뉴삭제
입력 : 1

할인정보를 입력해주세요
1. 국가유공자
2. 군인
3. 학생
4. 일반인
입력 : 1
주문이 완료되었습니다. 금액은 w 9.8 입니다.
</code></pre>
- 잘못된 입력에 대한 예외처리 구현
>출력
<pre><code>
  [ MAIN MENU ]
1. Burgers        
2. Drinks         
3. Desserts       
0. 종료
입력 : 5

올바른 선택지를 입력하세요!!
</code></pre>
- Enum을 사용해 사용자 유형별 할인율 관리
> Discount
<pre><code>
 public enum Discount {
    Patriot(10,"국가유공자"),
    Soldier(5,"군인"),
    Student(3,"학생"),
    General(0,"일반인");

    private final int discountRate;
    private final String name;
    Discount(int discountRate, String name) {
        this.discountRate = discountRate;
        this.name= name;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public String getName() {
        return name;
    }
}
</code></pre>
- 람다 & 스트림을 활용해 장바구니 조회기능, 장바구니 삭제기능 구현
> 출력
<pre><code>
  [ Orders ]
Milkshake      | w 5.5  | 수량 : 1    | 바닐라 아이스크림과 우유로 만든 밀크쉐이크

[ Total ]
w 5.5 

1. 주문      2. 메뉴판      3. 메뉴삭제
입력 : 3
장바구니에서 삭제할 메뉴입력 : Milkshake

장바구니에서 해당 메뉴를 삭제했습니다.
</code></pre>
