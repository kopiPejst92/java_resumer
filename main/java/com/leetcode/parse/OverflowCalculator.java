package com.leetcode.parse;

public class OverflowCalculator {
    /**
     * Oblicza o ile wartość long przekracza zakres int.
     * Zwraca wartość dodatnią, jeśli powyżej MAX_VALUE,
     * lub ujemną, jeśli poniżej MIN_VALUE.
     */
    public static long getExcess(long value) {
        if (value > Integer.MAX_VALUE) {
            return value - Integer.MAX_VALUE;
        } else if (value < Integer.MIN_VALUE) {
            return value - Integer.MIN_VALUE;
        }
        return 0; // Wartość mieści się w zakresie
    }
}
