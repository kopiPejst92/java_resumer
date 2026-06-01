package com.leetcode.sort;

public class MergeSort {

    // Główna metoda wywołująca sortowanie
    public static void mergeSort(String[] array) {
        if (array == null || array.length < 2) {
            return; // Tablica pusta lub jednoelementowa jest już posortowana
        }
        sort(array, 0, array.length-1);
    }

    // Metoda rekurencyjna dzieląca tablicę
    private static void sort(String[] array, int left, int right) {
        if (left < right) {
            // Znajdujemy punkt środkowy
            int mid = left +(right-left)/2;

            // Sortujemy pierwszą i drugą połowę
            sort(array, left, mid);
            sort(array, mid + 1, right);

            // Scalamy posortowane połowy
            merge(array, left, mid, right);
        }
    }

    // Metoda scalająca dwie podtablice
    private static void merge(String[] array, int left, int mid, int right) {
        // Obliczamy rozmiary dwóch podtablic do scalenia
        int n1 = mid - left + 1;
        int n2 = right - mid;

        String[] leftArr=new String[n1];
        String[] rightArr= new String[n2];
        for(int i=0; i<n1; i++){
            leftArr[i]=array[left+i];
        }
        for(int j=0; j<n1; j++){
            rightArr[j]=array[mid+1+j];
        }

        // Początkowe indeksy podtablic oraz tablicy scalonej
        int i = 0, j = 0;
        int k = left;

        // Główna pętla scalająca – tutaj używamy Twojego warunku!
        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j])<0) {
                array[k++] = leftArr[i++];
            } else {
                array[k++] = rightArr[j++];
            }
        }

        // Przepisujemy pozostałe elementy z leftArr[], jeśli jakieś zostały
        while (i < n1) {
            array[k++] = leftArr[i++];
        }

        // Przepisujemy pozostałe elementy z rightArr[], jeśli jakieś zostały
        while (j < n2) {
            array[k++] = rightArr[j++];
        }
    }
    private static void printArray(String[] array) {
        for (String str : array) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    // Prosty test działania algorytmu
    static void main(String[] args) {
        String[] data={"abracadabra", "abra", "lacabra", "cabra"};

        System.out.println("Tablica przed sortowaniem:");
        printArray(data);

        mergeSort(data);

        System.out.println("\nTablica po sortowaniu:");
        printArray(data);
    }}