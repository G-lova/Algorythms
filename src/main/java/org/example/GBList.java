package org.example;

import org.example.list.GBNode;

public interface GBList<T> {
    void addFirst(T t);
    void addLast(T t);
    GBNode<T> remove(int index);
    GBNode<T> get(int index);
    int size();
}