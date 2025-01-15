package com.example.lv6;

import java.util.Scanner;

public class InputInteger {
    static Scanner sc = new Scanner(System.in);
    public static int inputInteger() {
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
