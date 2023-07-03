package org.example;

import org.example.list.GBLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static org.example.HeapSort.sort;
import static org.example.RedBlackTree.printTree;

public class Main {
    public static void main(String[] args) {
//        int[] arrayExample = {6,58,4,3,16,5,83,1,7};
//        System.out.println(Arrays.toString(arrayExample));
//        sort(arrayExample);
//        System.out.println(Arrays.toString(arrayExample));


//        GBLinkedList<Integer> list = new GBLinkedList<>();
//        list.addLast(36);
//        list.addLast(49);
//        list.addLast(68);
//        list.addLast(6);
//        list.addLast(65);
//        list.print();
//        System.out.println("--- 1 способ: обратная итерация ---");
//        list.printBack();
//        System.out.println("--- 2 способ: смена ссылок ---");
//        list.reverse();
//        list.print();

        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    printTree(tree.getRoot(), null, false);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}