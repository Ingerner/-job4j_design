package ru.job4j.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;


    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void addFirst(T value) {
        head = new Node<T>(value, head);
    }

    public T deleteFirst() {
        if (head == null) {
           throw new NoSuchElementException();
        }
        Node<T> deleteNode = head;
        head = deleteNode.next;
        deleteNode.next = null;
        return deleteNode.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean revert() {
        boolean rsl = false;
        if (!isEmpty() && head.next != null) {
            Node<T> cursor = head.next;
            head.next = null;
            while (cursor != null) {
                Node<T> next = cursor.next;
                cursor.next = head;
                head = cursor;
                cursor = next;
            }
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
           ForwardLinked.Node<T> node = head;

           @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
