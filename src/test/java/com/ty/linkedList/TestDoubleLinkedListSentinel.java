package com.ty.linkedList;

import org.junit.Test;

public class TestDoubleLinkedListSentinel {


    @Test
    public void test() {
        DoubleLinkedListSentinel doubleLinkedListSentinel = new DoubleLinkedListSentinel();

        for (int i = 10; i > 0; i--) {
            doubleLinkedListSentinel.addFirst(i);
        }

        for (int i = 11; i <= 15; i++) {
            doubleLinkedListSentinel.addLast(i);
        }

        doubleLinkedListSentinel.removeFirst();
        doubleLinkedListSentinel.removeFirst();
        doubleLinkedListSentinel.removeLast();
        doubleLinkedListSentinel.removeLast();

        doubleLinkedListSentinel.insert(0,0);
        doubleLinkedListSentinel.insert(1,1);

        for (int item : doubleLinkedListSentinel) {
            System.out.println(item);
        }


    }

}
