package com.ty.leetcode;

import com.ty.linkedList.SingleLinkedList;
import org.junit.Test;

import java.sql.Array;
import java.util.List;

public class TestLinkedList {

    @Test
    public void arrayToListNode() {
        int[] arr = new int[]{1, 2, 3};
        linkedList.ListNode node = linkedList.getInstance().arrayToListNode1(arr);
    }

    @Test
    public void leetCode_160_1() {
        //   4 1 8 4 5
        // 5 0 1 8 4 5
        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
        linkedList.ListNode node1 = list.get(0).head.next;
        linkedList.ListNode node2 = list.get(1).head.next;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_1(node1, node2);
        linkedList.getInstance().print(result);
    }


    @Test
    public void leetCode_160_2() {
        //   4 1 8 4 5
        // 5 0 1 8 4 5
        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
        linkedList.ListNode node1 = list.get(0).head.next;
        linkedList.ListNode node2 = list.get(1).head.next;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_2(node1, node2);
        linkedList.getInstance().print(result);
    }

    @Test
    public void leetCode_160_3() {
        //   4 1 8 4 5
        // 5 0 1 8 4 5
        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
        linkedList.ListNode node1 = list.get(0).head.next;
        linkedList.ListNode node2 = list.get(1).head.next;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_3(node1, node2);
        linkedList.getInstance().print(result);
    }

    @Test
    public void leetCode_160_4() {
        //case 1
        //   4 1 8 4 5
        // 5 0 1 8 4 5
//        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
//        linkedList.ListNode node1 = list.get(0).head.next;
//        linkedList.ListNode node2 = list.get(1).head.next;

        //case 2
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{10, 11, 12};

        linkedList.ListNode node1 = linkedList.getInstance().arrayToListNode1(arr1);
        linkedList.ListNode node2 = linkedList.getInstance().arrayToListNode1(arr2);

        node2.next = node1;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_4(node1, node2);
        linkedList.getInstance().print(result);
    }


    @Test
    public void isPalindrome() {
        linkedList linkedList = new linkedList();
        com.ty.leetcode.linkedList.ListNode head = linkedList.isPalindrome_Node1();
        linkedList.isPalindrome(head);
    }


    @Test
    public void test() {
        linkedList linkedList = new linkedList();
//        linkedList.reverseList01();
//        linkedList.reverseList02();
//        linkedList.reverseList03();
//        linkedList.deleteDuplicates();
        com.ty.leetcode.linkedList.ListNode node = linkedList.deleteDuplicates_Node();
        linkedList.deleteDuplicates(node);

//        linkedList.removeElements(node,3);
//        linkedList.deleteDuplicates2(node);
    }

    @Test
    public void mergeTwoLists() {
        linkedList linkedList = new linkedList();
        com.ty.leetcode.linkedList.ListNode l1 = linkedList.mergeTwoListsNode1();
        com.ty.leetcode.linkedList.ListNode l2 = linkedList.mergeTwoListsNode2();
        com.ty.leetcode.linkedList.ListNode node = linkedList.mergeTwoLists(l1, l2);
    }

    @Test
    public void reverseList() {
        linkedList linkedList = new linkedList();
        com.ty.leetcode.linkedList.ListNode node = linkedList.getListNode();
        com.ty.leetcode.linkedList.ListNode result = linkedList.reverseList(node);
    }


}
