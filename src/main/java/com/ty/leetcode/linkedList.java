package com.ty.leetcode;

import com.sun.org.apache.xerces.internal.util.SAXLocatorWrapper;
import com.ty.linkedList.SingleLinkedList;

import java.util.*;

/**
 * 链表相关LeetCode
 */
public class linkedList {

    private static linkedList singleton;

    public linkedList() {
    }

    public static linkedList getInstance() {
        if (singleton == null) {
            singleton = new linkedList();
        }
        return singleton;
    }


    /**
     * 环形链表_(快慢指针)
     */
    public boolean leetCode_141(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null){

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                return true;
            }
        }
        return false;
    }


    public List<MyLinkList> leetCode_160_Node() {
        // lsit1:   4 1 8 4 5
        // list2: 5 0 1 8 4 5
        ListNode node8 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        MyLinkList list1 = new MyLinkList();
        list1.add(new ListNode(4));
        list1.add(new ListNode(1));
        list1.add(node8);
        list1.add(node4);
        list1.add(node5);

        MyLinkList list2 = new MyLinkList();
        list2.add(new ListNode(5));
        list2.add(new ListNode(0));
        list2.add(new ListNode(1));
        list2.add(node8);

        List<MyLinkList> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);

        return list;
    }

    /**
     * 相交链表_（计算长度差来确定是否有交叉节点）
     */
    public ListNode leetCode_160_1(ListNode node1, ListNode node2) {

        //如果是空链表返回
        //创建两个指针分别指向两个链表
        //获取链表的长度
        //计算出长度差

        //   4 1 8 4 5
        // 5 0 1 8 4 5

        if (node1 == null || node2 == null) {
            return null;
        }

        ListNode pointA = node1;
        ListNode pointB = node2;

        int lengthA = leetCode_160_1_getLength(pointA);
        int lengthB = leetCode_160_1_getLength(pointB);


        if (lengthA > lengthB) {
            int diff = lengthA - lengthB;
            while (diff-- > 0) {
                pointA = pointA.next;
            }
        } else {
            int diff = lengthB - lengthA;
            while (diff-- > 0) {
                pointB = pointB.next;
            }
        }

        while (pointA != pointB) {
            pointA = pointA.next;
            pointB = pointB.next;
        }

        return pointA;
    }

    /**
     * 相交链表_（双指针）
     */
    public ListNode leetCode_160_2(ListNode node1, ListNode node2) {
        // a + c + b
        // b + c + a
        //如果相交，那么一定 a + c + b = b + c + a
        if (node1 == null || node2 == null) {
            return null;
        }

        ListNode pointA = node1;
        ListNode pointB = node2;

        //如果不相等则一直比对
        while (pointA != pointB) {
            pointA = pointA != null ? pointA.next : node2;
            pointB = pointB != null ? pointB.next : node1;
        }

        return pointA;
    }

    /**
     * 相交链表_（hashset实现）
     */
    public ListNode leetCode_160_3(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }

        ListNode temp = node1;
        HashSet<ListNode> hashSet = new LinkedHashSet<>();
        while (temp != null) {
            hashSet.add(temp);
            temp = temp.next;
        }

        while (node2 != null) {
            if (hashSet.contains(node2)) {
                return node2;
            }
            node2 = node2.next;
        }

        return null;
    }

    /**
     * 相交链表_（构成一个环）
     */
    public ListNode leetCode_160_4(ListNode node1, ListNode node2) {

        //找到headA节点的尾节点，指向headB的头结点
        //使用快慢指针找到相交节点,快指针再回到头结点继续找，同时走一步
        //不管是否找到，都将headA的尾节点指向null


        ListNode curA = node1;

        while (curA != null && curA.next != null) {
            curA = curA.next;
        }

        curA.next = node2;

        ListNode fast = node1;
        ListNode slow = node1;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {

                fast = node1;

                while (fast != null && fast.next != null) {
                    if (fast == slow) {
                        curA.next = null;
                        return fast;
                    }
                    fast = fast.next;
                    slow = slow.next;
                }

                return fast;
            }
        }
        curA.next = null;
        return null;
    }

    private int leetCode_160_1_getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public ListNode isPalindrome_Node1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        return listNode1;
    }


    public boolean isPalindrome(ListNode head) {
        // 1 2 2 1
        // millde = 2 1
        // reverse = 1 2
        ListNode middle = this.middle(head);

        ListNode reverse = this.reverse(middle);


        if (reverse != null) {
            while (reverse != null) {

                if (reverse.val != head.val) {
                    return false;
                }
                reverse = reverse.next;
                head = head.next;
            }
        }
        return true;
    }

    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }


    private ListNode middle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }


    public ListNode mergeTwoListsNode1() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    public ListNode mergeTwoListsNode2() {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    public ListNode getListNode() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }


    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        System.out.println("before-head:" + head.val);
        ListNode temp = reverseList(head.next);
        System.out.println("after-head:" + head.val);

        head.next.next = head;
        head.next = null;

        return temp;

    }

    public ListNode deleteDuplicates_Node() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }


    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        ListNode p3;
        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                while ((p3 = p3.next) != null
                        && p3.val == p2.val) {
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return s.next;
    }


    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }


    }

    public ListNode deleteDuplicates() {
        ListNode node = deleteDuplicates_Node();

        if (node == null || node.next == null) {
            return node;
        }

        ListNode p1 = node;
        ListNode p2;

        while ((p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
            } else {
                p1 = p1.next;
            }
        }
        return node;
    }

    public ListNode deleteDuplicates2(ListNode node) {
        if (node == null || node.next == null) {
            return null;
        }

        if (node.val == node.next.val) {
            return deleteDuplicates2(node.next);
        } else {
            node.next = deleteDuplicates2(node.next);
            return node;
        }
    }

    /**
     * 递归
     */
    public void reverseList03() {
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
        // 5 -> 4 -> 3 -> 2 -> 1 -> null
        ListNode node = getListNode();
        ListNode recursionNode = reverseList03_Recursion(node);
        System.out.println(recursionNode.val);
    }

    private ListNode reverseList03_Recursion(ListNode node) {

        if (node == null || node.next == null) {
            return node;
        }
        ListNode last = reverseList03_Recursion(node.next);

        return last;
    }


    /**
     * 双指针
     */
    public void reverseList02() {
        ListNode curr = getListNode();
        ListNode newNode = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = newNode;
            newNode = curr;
            curr = next;
        }
    }

    public void reverseList01() {
        ListNode listNode = getListNode();
        ListNode newListNode = null;

        while (listNode != null) {
            newListNode = new ListNode(listNode.val, newListNode);
            listNode = listNode.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class MyLinkList {
        ListNode head = new ListNode(-1);

        public void add(ListNode listnode) {
            ListNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = listnode;
        }
    }
}
