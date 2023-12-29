package com.ty.queue;

import org.junit.Test;

public class TestMyLinkedListQueue {

    @Test
    public void test() {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);


        Object p1 = queue.peek();
        Object p2 = queue.peek();
        Object p3 = queue.peek();

        Object val1 = queue.poll();
        Object val2 = queue.poll();
        Object val3 = queue.poll();

    }

}
