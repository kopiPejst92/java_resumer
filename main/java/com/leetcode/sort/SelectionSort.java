package com.leetcode.sort;

public class SelectionSort implements Sort{

    @Override
    public String[] sort(String[] toBeSorted) {
        for(int i=0; i<toBeSorted.length; i++){
            int minIndex=i;
            for(int j=i+1; j<toBeSorted.length; j++){
                if(toBeSorted[j].compareTo(toBeSorted[minIndex])<0){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                swap(toBeSorted, i, minIndex);
            }
        }
        return toBeSorted;
    }

    @Override
    public int[] sort(int[] toBeSorted) {
        for(int i=0; i<toBeSorted.length; i++){
            int minIndex=i;
            for(int j=i+1; j<toBeSorted.length; j++){
                if(toBeSorted[j]<toBeSorted[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                swap(toBeSorted, i, minIndex);
            }
        }
        return toBeSorted;
    }

}
