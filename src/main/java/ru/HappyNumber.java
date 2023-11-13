package ru;

import java.util.Scanner;

public class HappyNumber {

    public String happyNumberFunc(String num) {
        if (num.length() != 6) {
            throw new RuntimeException("Введён неправильный номер билета");
        }
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            throw new RuntimeException("Введён неправильный номер билета");
        }
        int number1 = 0;
        int number2 = 0;
        for (int i = 0; i < num.length(); i++) {
            if (i < 3) {
                number1 += Integer.parseInt(num.substring(i, i + 1));
            } else {
                number2 += Integer.parseInt(num.substring(i, i + 1));
            }
        }
        if (number1 == number2) {
            return "true";
        } else {
            return "false";
        }
    }
}
