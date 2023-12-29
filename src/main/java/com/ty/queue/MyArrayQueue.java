package com.ty.queue;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayQueue<T> implements IMyQueue<T>, Iterable<T> {


    private int head = 0;
    private int tail = 0;
    private final T[] array;
    private final int length;

    public MyArrayQueue(int capacity) {
        array = (T[]) new Object[capacity + 1];
        length = capacity + 1;
    }

    @Override
    public boolean offer(T value) {
        if (isFull()) {
            return false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        }

        T value = array[head];
        head = (head + 1) % array.length;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return array[head];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return (tail + 1) % array.length == head;
    }

    @Override
    public Iterator<T> iterator() {


        return new Iterator<T>() {
            int cur = head;

            @Override
            public boolean hasNext() {
                return cur != tail;
            }

            @Override
            public T next() {
                T value = array[cur];
                cur = (cur + 1) % array.length;
                return value;
            }
        };
    }
}
