package ru.job4j.list;

import java.util.*;

public class SimpleLinkedList<E> implements List1<E> {

    private  int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

        @Override
    public void add(E value) {
            final Node<E> lastNode = last;
            final Node<E> newNode = new Node<>(lastNode, value, null);
            last = newNode;
            if (lastNode == null) {
                first = newNode;
            } else {
                lastNode.next = newNode;
            }
            size++;
            modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rslNode = first;
        for (int i = 1; i <= index; i++) {
            rslNode = first.next;
        }
        return rslNode.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            Node<E> cursor = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> rslCursor = cursor;
                cursor = cursor.next;
                return rslCursor.item;
            }
        };
    }
}
