package com.ty.leetcode;

public class ToolMethod {

    private static ToolMethod singleton;

    public ToolMethod(){}

    public static ToolMethod getInstance(){
        if (singleton == null){
            singleton = new ToolMethod();
        }
        return singleton;
    }

    /**
     * 数组转链表1
     */
    public linkedList.ListNode arrayToListNode1(int[] arr) {
        linkedList.ListNode node = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            node = new linkedList.ListNode(arr[i], node);
        }
        return node;
    }

    /**
     * 数组转链表2_（带哨兵）
     */
    public linkedList.ListNode arrayToListNode2(int[] arr) {
        linkedList.ListNode sentinel = new linkedList.ListNode(-1);
        linkedList.ListNode temp = sentinel;
        for (int i = 0; i < arr.length; i++) {
            linkedList.ListNode newNode = new linkedList.ListNode(arr[i]);
            temp.next = newNode;
            temp = newNode;
        }
        return sentinel;
    }

    /**
     * 设置环形链表
     * */
    public linkedList.ListNode setCycleNode(linkedList.ListNode node1, linkedList.ListNode node2){
        linkedList.ListNode temp1 = node1;
        while (temp1.next != null){
            temp1 = temp1.next;
        }
        temp1.next = node2;
        return node1;
    }

    /**
     * 设置环形链表
     * */
    public linkedList.ListNode setCycleNode(linkedList.ListNode node1, linkedList.ListNode node2,linkedList.ListNode node3){
        linkedList.ListNode temp1 = node1;
        linkedList.ListNode temp2 = node2;
        linkedList.ListNode temp3 = node3;

        while (temp1.next != null){
            temp1 = temp1.next;
        }
        temp1.next = node2;


        while (temp2.next != null){
            temp2 = temp2.next;
        }
        temp2.next = node3;

        while (temp3.next != null){
            temp3 = temp3.next;
        }
        temp3.next = node2;

        return node1;
    }

    /**
     * 打印链表节点值
     */
    public void print(linkedList.ListNode node) {
        System.out.println("====start print====");
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public int getNodeLength(linkedList.ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }




}
