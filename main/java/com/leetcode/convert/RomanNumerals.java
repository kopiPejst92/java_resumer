package com.leetcode.convert;

public class RomanNumerals {
    public static String convertToRoman(int number) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] arabian = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < arabian.length; i++) {
            // Dopóki nasza liczba jest większa lub równa aktualnej wartości z tabeli
            while (number >= arabian[i]) {
                number -= arabian[i];
                stringBuilder.append(roman[i]);
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int case1 = 3749;
        System.out.println(convertToRoman(case1));

    }

}
