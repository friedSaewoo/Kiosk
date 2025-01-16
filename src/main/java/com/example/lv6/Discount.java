package com.example.lv6;

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
