package com.leetcode.sort;

public class WeightSort {

    public static String orderWeight(String strng) {
        String[] weights= strng.split(" ");
        for(int i=0; i<weights.length-1; i++){
            for(int j=0; j<weights.length-i-1; j++){
                int sum1=getSum(weights[j]);
                int sum2=getSum(weights[j+1]);
                if(sum2<sum1 || (sum1==sum2 && weights[j].compareTo(weights[j+1])> 0)){
                    swapElements(weights, j, j+1);
                }
            }

        }
        return String.join(" ", weights);
    }

    private static void swapElements(String[] weights, int k, int l) {
        String temp=weights[k];
        weights[k]=weights[l];
        weights[l]=temp;
    }

    public static int getSum(String numberToSum){
        int sum=0;
        for(char letter: numberToSum.toCharArray()){
            sum+=letter-'0';
        }
        return sum;
    }

    static void main(String[] args){
        String strng = "56 65 74 100 99 68 86 180 90";
        System.out.println(orderWeight(strng));
    }
}
