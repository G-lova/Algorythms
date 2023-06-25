package org.example.list;

public class GBNode<T> {
    T value;
    GBNode<T> next;
    GBNode<T> prev;

    public GBNode(GBNode<T> prev, T element, GBNode<T> next) {
        this.value = element;
        this.next = next;
        this.prev = prev;
    }

    public GBNode(T element) {
        this(null, element, null);
    }

    @Override
    public String toString() {
        return String.format("%s", value);
    }
}
