package com.ty.queue;

import java.util.Iterator;

/**
 * 单向循环链表(尾节点指向头节点)
 */
public class MyLinkedListQueue<T> implements IMyQueue<T>, Iterable<T> {

    private Node<T> head = new Node<>(null, null);
    private Node<T> tail = head;

    private int size = 0;
    private int capacity = Integer.MAX_VALUE;


    public MyLinkedListQueue() {
        ;
        tail.next = head;
    }


    @Override
    public boolean offer(T value) {
        if (isFull()) {
            return false;
        }
        Node added = new Node<T>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        Node<T> first = head.next;
        head.next = first.next;

        if (first == tail) {
            head = tail;
        }
        size--;
        return first.value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cur = head.next;

            @Override
            public boolean hasNext() {
                return cur != head;
            }

            @Override
            public T next() {
                T value = cur.value;
                cur = cur.next;
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
