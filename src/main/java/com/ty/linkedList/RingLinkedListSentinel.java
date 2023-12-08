package com.ty.linkedList;

import java.util.Iterator;

/**
 * 环形链表（带哨兵）
 */
public class RingLinkedListSentinel implements Iterable<Integer> {

    private final Node sentinel = new Node(Integer.MAX_VALUE, null, null);

    public RingLinkedListSentinel() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    public void removeByValue(int value) {
        Node removed = findByValue(value);

        if (removed == null) {
            throw new IllegalArgumentException("删除节点为空");
        }
        Node prev = removed.prev;
        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    private Node findByValue(int value) {
        Node temp = sentinel;
        while (temp.next != sentinel) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }


    public void removeFirst() {

        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法操作");
        }
        sentinel.next = removed.next;
        removed.next.prev = sentinel;

    }

    public void removeLast() {
        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法操作");
        }
        sentinel.prev = removed.prev;
        removed.prev.next = sentinel;
    }

    public void addFirst(int value) {
        Node prev = sentinel;
        Node next = sentinel.next;
        Node inserted = new Node(value, prev, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void addLast(int value) {
        Node prev = sentinel.prev;
        Node next = sentinel;
        Node inserted = new Node(value, prev, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node temp = sentinel.next;

            @Override
            public boolean hasNext() {
                return temp != sentinel;
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
