package com.leetcode.sort;

public interface Sort {
    String[] sort(String[] toBeSorted);

    int[] sort(int[] toBeSorted);

    default int[] swap(int[] arrayToSort, int n, int m) {
        int temp = arrayToSort[m];
        arrayToSort[m] = arrayToSort[n];
        arrayToSort[n] = temp;
        return arrayToSort;
    }

    default String[] swap(String[] arrayToSort, int n, int m) {
        String temp = arrayToSort[m];
        arrayToSort[m] = arrayToSort[n];
        arrayToSort[n] = temp;
        return arrayToSort;
    }
}
