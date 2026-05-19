package com.leetcode.sort;

public class BubbleSort implements Sort{

    @Override
    public String[] sort(String[] toBeSorted) {
        for(int i=0; i<toBeSorted.length-1; i++){
            int j=i+1;
            String a=toBeSorted[i];
            String b=toBeSorted[j];
            if(a.compareTo(b)<0) swap(toBeSorted, i,j);
        }
        return toBeSorted;
    }

    @Override
    public int[] sort(int[] toBeSorted) {
        for(int i=0; i<toBeSorted.length-1; i++){
            int j=i+1;
            if(toBeSorted[j]<toBeSorted[i]) swap(toBeSorted, i,j);
        }
        return toBeSorted;
    }
}

