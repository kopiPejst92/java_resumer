package com.leetcode.problems;

public class Palindrome {
    public static boolean isPalindrome(int x) {
        int original = x, reversed = 0;
        if (x == 0 || (x > 0 && x / 10 < 1)) return true;
        else {
            while (x > 0) {
                int rest = x % 10;
                reversed = reversed * 10 + rest;
                x = (x - rest) / 10;
            }
        }
        return original == reversed;
    }


    private static boolean checkPal(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low) != s.charAt(high))
                    return false;
                low++;
                high--;
            }
            return true;
    }

    public static String getLongestPal(String s) {
            int start=0;
            int n = s.length();
            int maxLen=1;
            for(int i=0; i<n; i++){
                for(int j=0; j<=1; j++){
                    int left=i;
                    int right=i+j;
                    while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                        int currentH=right-left+1;
                        if(currentH>maxLen){
                            maxLen=currentH;
                            start=left;
                        }
                        left--;
                        right++;
                    }
                }

            }
        return s.substring(start, start+maxLen);
    }

public static void main(String[] args) {
    String case1 = "badbab", case2 = "cbbc", case3 = "kobylamalybok";
    System.out.println(Palindrome.getLongestPal(case1));
}}