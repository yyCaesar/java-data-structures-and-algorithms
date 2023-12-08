package com.ty.linkedList;

import java.util.Iterator;

/**
 * 双向链表(带哨兵)
 */
public class DoubleLinkedListSentinel implements Iterable<Integer> {

    private Node head;
    private Node tail;

    public DoubleLinkedListSentinel() {
        head = new Node(Integer.MAX_VALUE, null, null);
        tail = new Node(Integer.MIN_VALUE, null, null);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(int value) {
        insert(0, value);
    }

    public void addLast(int value) {
        //尾部添加
        Node prev = tail.prev;
        Node inserted = new Node(value, prev, tail);
        prev.next = inserted;
        tail.prev = inserted;
    }


    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        //尾指针
        //如果 head - tail
        Node removed = tail.prev;
        if (removed == head){
            throw illegalIndex(0);
        }

        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }

        Node removed = prev.next;
        if (removed == null) {
            throw illegalIndex(index);
        }

        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }

        Node next = prev.next;
        Node inserted = new Node(value, prev, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    private Node findNode(int index) {
        int i = -1;
        for (Node temp = head; temp != tail; temp = temp.next, i++) {
            if (i == index) {
                return temp;
            }
        }
        return null;
    }


    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node temp = head.next;
            @Override
            public boolean hasNext() {
                return temp != tail;
            }

            @Override
            public Integer next() {
                int value = temp.value;
                temp = temp.next;
                return value;
            }
        };
    }

    static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }

    }


}
