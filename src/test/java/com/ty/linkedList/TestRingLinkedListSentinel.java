package com.ty.linkedList;

import org.junit.Test;

public class TestRingLinkedListSentinel {

    @Test
    public void test() {

        RingLinkedListSentinel ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(1);

        ringLinkedListSentinel.addLast(4);
        ringLinkedListSentinel.addLast(5);
        ringLinkedListSentinel.addLast(6);

        ringLinkedListSentinel.removeFirst();
        ringLinkedListSentinel.removeFirst();

        ringLinkedListSentinel.removeLast();
        ringLinkedListSentinel.removeLast();

        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addLast(5);
        ringLinkedListSentinel.addLast(6);

        ringLinkedListSentinel.removeByValue(5);

        for (int item : ringLinkedListSentinel) {
            System.out.println(item);
        }
    }

}
