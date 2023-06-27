package org.example;

import org.example.list.GBLinkedList;

import java.util.Arrays;

import static org.example.HeapSort.sort;

public class Main {
    public static void main(String[] args) {
//        int[] arrayExample = {6,58,4,3,16,5,83,1,7};
//        System.out.println(Arrays.toString(arrayExample));
//        sort(arrayExample);
//        System.out.println(Arrays.toString(arrayExample));


        GBLinkedList<Integer> list = new GBLinkedList<>();
        list.addLast(36);
        list.addLast(49);
        list.addLast(68);
        list.addLast(6);
        list.addLast(65);
        list.print();
        System.out.println("--- 1 способ: обратная итерация ---");
        list.printBack();
        System.out.println("--- 2 способ: смена ссылок ---");
        list.reverse();
        list.print();

    }
}