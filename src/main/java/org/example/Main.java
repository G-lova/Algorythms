package org.example;

import java.util.Arrays;

import static org.example.HeapSort.sort;

public class Main {
    public static void main(String[] args) {
        int[] arrayExample = {6,58,4,3,16,5,83,1,7};
        System.out.println(Arrays.toString(arrayExample));
        sort(arrayExample);
        System.out.println(Arrays.toString(arrayExample));
    }
}