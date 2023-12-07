package com.ty.linkedList;

import org.junit.Test;

public class TestSingleLinkedListSentinel {

    @Test
    public void test() {
        SingleLinkedListSentinel singleLinkedListSentinel = new SingleLinkedListSentinel();
        singleLinkedListSentinel.addFirst(2);
        singleLinkedListSentinel.addFirst(1);
        singleLinkedListSentinel.addLast(3);
        singleLinkedListSentinel.addLast(4);

        singleLinkedListSentinel.insert(4,5);
        singleLinkedListSentinel.print();

        singleLinkedListSentinel.remove(4);
        singleLinkedListSentinel.remove(3);
        singleLinkedListSentinel.remove(2);
        singleLinkedListSentinel.remove(1);
        singleLinkedListSentinel.remove(0);

        singleLinkedListSentinel.print();

    }
}
