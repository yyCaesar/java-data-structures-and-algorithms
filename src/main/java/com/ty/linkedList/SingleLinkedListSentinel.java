package com.ty.linkedList;

/**
 * 单向链表(带哨兵)
 */
public class SingleLinkedListSentinel {

    private Node head = new Node(Integer.MAX_VALUE, null);

    public void addFirst(int value) {
        this.head.next = new Node(value, this.head.next);
    }

    public void addLast(int value) {
        Node last = findLast();
        last.next = new Node(value, null);
    }

    public void insert(int index, int value) {

        Node prev = findNode(index - 1);

        if (prev == null) {
            throw illegalIndex(index);
        }

        prev.next = new Node(value, prev.next);
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        Node curr;
        if (prev != null && (curr = prev.next) != null) {
            prev.next = curr.next;
        } else {
            throw illegalIndex(index);
        }
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }


    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    private Node findNode(int index) {

        int i = -1;
        for (Node temp = this.head; temp != null; temp = temp.next, i++) {
            if (i == index) {
                return temp;
            }
        }
        return null;
    }

    private Node findLast() {
        Node temp;
        for (temp = head; temp.next != null; temp = temp.next) {

        }
        return temp;
    }


    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


}
