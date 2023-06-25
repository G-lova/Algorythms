package org.example.list;

import org.example.GBList;

public class GBLinkedList<T> implements GBList<T> {

    int size = 0;
    GBNode<T> head;
    GBNode<T> tail;

    public GBLinkedList() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void addFirst(T element) {
        GBNode<T> item = new GBNode<>(element);
        if (size == 0) tail = item;
        else head.prev = item;
        item.next = head;
        head = item;
        size++;
    }

    @Override
    public void addLast(T element) {
        GBNode<T> item = new GBNode<>(element);
        if (size == 0) head = item;
        else tail.next = item;
        item.prev = tail;
        tail = item;
        size++;
    }

    @Override
    public GBNode<T> remove(int index) {
        if ((index < 0) || (index >= size)) return null;
        GBNode<T> element = get(index);
        if ((index > 0) && (index < size - 1)) {
            GBNode<T> elementPrev = get(index - 1);
            GBNode<T> elementNext = get(index + 1);
            elementPrev.next = elementNext;
            elementNext.prev = elementPrev;
        }
        if (index == 0) {
            GBNode<T> elementNext = get(index + 1);
            elementNext.prev = null;
            head = elementNext;
        }
        if (index == size - 1) {
            GBNode<T> elementPrev = get(index - 1);
            elementPrev.next = null;
            tail = elementPrev;
        }
        size--;
        return element;
    }

    @Override
    public GBNode<T> get(int index) {
        if ((size == 0) || (index >= size)) return null;
        GBNode<T> element = head;
        for (int i = 0; i < index; i++) {
            element = element.next;
        }
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    public void print() {
        GBNode<T> node = head;
        while (node != null) {
            T out = node.value;
            node = node.next;
            System.out.printf("%s ", out.toString());
        }
        System.out.println();
    }

    public void printBack() {
        GBNode<T> node = tail;
        while (node != null) {
            T out = node.value;
            node = node.prev;
            System.out.printf("%s ", out.toString());
        }
        System.out.println();
    }
}
