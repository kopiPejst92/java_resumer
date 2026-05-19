package com.leetcode.problems.numeric;

public class PrimeNumbers {

    public static boolean isPrime(int num){
        if(num<2) return false;
        else if(num==2 || num==3){
            return true;
        }
        else{
            int sqrt = (int) Math.ceil(Math.sqrt(num));
            int i=2;
            while(i<=sqrt){
                if(num%i==0) return false;
                i+=1;
            }
        }
        return true;
    }

    static void main(String[] args){
        int notPassed=15342889;
        System.out.println(PrimeNumbers.isPrime(notPassed));
    }
}
