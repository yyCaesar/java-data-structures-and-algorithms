package com.ty.leetcode;

import com.ty.linkedList.SingleLinkedList;
import org.junit.Test;

import java.sql.Array;
import java.util.List;

public class TestLinkedList {

    private linkedList _linkedList() {
        return linkedList.getInstance();
    }

    private ToolMethod _toolMethod() {
        return ToolMethod.getInstance();
    }


    @Test
    public void Test() {

        int a = 35;
        int a_1 = 35 / 32;

        int b = 35 % 32;
        int b_1 = 1 << b;

    }

    //======================================

    @Test
    public void leetCode_kthToLast(){
        int[] arr1 = new int[]{1, 2, 3, 4,  5};
        linkedList.ListNode node1 = _toolMethod().arrayToListNode2(arr1);
        _linkedList().leetCode_kthToLast_1(node1,2);

    }

    @Test
    public void leetCode_removeDuplicateNodes() {
        int[] arr1 = new int[]{1, 2, 3, 3, 2, 1};
        linkedList.ListNode node1 = _toolMethod().arrayToListNode2(arr1);
        linkedList.ListNode result = _linkedList().leetCode_removeDuplicateNodes_2(node1);
        _toolMethod().print(result);
    }


    @Test
    public void leetCode_142_trainningPlan_1() {
        int[] arr1 = new int[]{1, 2, 4};
        int[] arr2 = new int[]{1, 3, 4};
        linkedList.ListNode node1 = _toolMethod().arrayToListNode2(arr1);
        linkedList.ListNode node2 = _toolMethod().arrayToListNode2(arr2);
        linkedList.ListNode result = _linkedList().leetCode_142_trainningPlan_1(node1, node2);
        _toolMethod().print(result);
    }


    @Test
    public void leetCode_140_trainingPlan() {
        int[] arr = new int[]{2, 4, 7, 8};
        linkedList.ListNode node = _toolMethod().arrayToListNode2(arr);
        linkedList.ListNode result = _linkedList().leetCode_140_trainingPlan_2(node, 1);
        _toolMethod().print(result);
    }

    @Test
    public void leetCode_24_1() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        linkedList.ListNode node1 = _toolMethod().arrayToListNode1(arr1);
        linkedList.ListNode result = _linkedList().leetCode_24_1(node1);
    }

    @Test
    public void leetCode_142() {

        int[] arr1 = new int[]{5, 3, 2, 7};
        int[] arr2 = new int[]{1, 6, 8};
        int[] arr3 = new int[]{9, 4};

        linkedList.ListNode node1 = ToolMethod.getInstance().arrayToListNode1(arr1);
        linkedList.ListNode node2 = ToolMethod.getInstance().arrayToListNode1(arr2);
        linkedList.ListNode node3 = ToolMethod.getInstance().arrayToListNode1(arr3);
        linkedList.ListNode node = ToolMethod.getInstance().setCycleNode(node1, node2, node3);

        linkedList.ListNode result = linkedList.getInstance().leetCode_142(node1);
    }

    @Test
    public void leetCode_141() {
        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[]{4, 5, 7};
        int[] arr3 = new int[]{10, 11, 12};

        linkedList.ListNode node1 = ToolMethod.getInstance().arrayToListNode1(arr1);
        linkedList.ListNode node2 = ToolMethod.getInstance().arrayToListNode1(arr2);
        linkedList.ListNode node3 = ToolMethod.getInstance().arrayToListNode1(arr3);
        linkedList.ListNode node = ToolMethod.getInstance().setCycleNode(node1, node2, node3);
        boolean result = linkedList.getInstance().leetCode_141(node);
        System.out.println(result);
    }

    @Test
    public void leetCode_160_1() {
        //   4 1 8 4 5
        // 5 0 1 8 4 5
        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
        linkedList.ListNode node1 = list.get(0).head.next;
        linkedList.ListNode node2 = list.get(1).head.next;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_1(node1, node2);
        ToolMethod.getInstance().print(result);
    }

    @Test
    public void leetCode_160_2() {
        //   4 1 8 4 5
        // 5 0 1 8 4 5
        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
        linkedList.ListNode node1 = list.get(0).head.next;
        linkedList.ListNode node2 = list.get(1).head.next;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_2(node1, node2);
        ToolMethod.getInstance().print(result);
    }

    @Test
    public void leetCode_160_3() {
        //   4 1 8 4 5
        // 5 0 1 8 4 5
        List<linkedList.MyLinkList> list = linkedList.getInstance().leetCode_160_Node();
        linkedList.ListNode node1 = list.get(0).head.next;
        linkedList.ListNode node2 = list.get(1).head.next;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_3(node1, node2);
        ToolMethod.getInstance().print(result);
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

        linkedList.ListNode node1 = ToolMethod.getInstance().arrayToListNode1(arr1);
        linkedList.ListNode node2 = ToolMethod.getInstance().arrayToListNode1(arr2);

        node2.next = node1;

        linkedList.ListNode result = linkedList.getInstance().leetCode_160_4(node1, node2);
        ToolMethod.getInstance().print(result);
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
