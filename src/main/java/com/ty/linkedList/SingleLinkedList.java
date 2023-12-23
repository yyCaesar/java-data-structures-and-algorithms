package com.ty.linkedList;


/**
 * 单向链表
 */
public class SingleLinkedList {

    Node head;

    public void addFirst(int value) {
        this.head = new Node(value, head);
    }

    public void addLast(int value) {
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);

    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }


    }

    public Node findLast() {
        if (head == null) {
            return null;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    private Node findNode(int index) {
        int i = 0;
        for (Node temp = head; temp != null; temp = temp.next, i++) {
            if (i == index) {
                return temp;
            }
        }
        return null;
    }

    public void insert(int index, int value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        //找上一个节点
        Node prev = findNode(index - 1);

        if (prev == null) {
            throw illegalIndex(index);
        }

        prev.next = new Node(value, prev.next);
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    public void remove(int index) {
        if (index == 0) {
            if (this.head != null) {
                this.head = null;
                return;
            } else {
                throw illegalIndex(index);
            }
        }

        Node prev = findNode(index - 1);
        Node curr;
        if (prev != null && (curr = prev.next) != null) {
            prev.next = prev.next.next;
        } else {
            throw illegalIndex(index);
        }


    }

    public static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
