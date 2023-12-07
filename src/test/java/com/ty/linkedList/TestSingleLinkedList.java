package com.ty.linkedList;

import org.junit.Test;

import javax.xml.soap.Node;

public class TestSingleLinkedList {

    @Test
    public void test() {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addFirst(3);
        singleLinkedList.addFirst(2);
        singleLinkedList.addFirst(1);

        singleLinkedList.addLast(4);

        singleLinkedList.insert(4, 5);

        singleLinkedList.remove(2);
        singleLinkedList.print();
    }

}
