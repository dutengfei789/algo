package com.tengfei.algo.demo.array;

public class GenericArray<E> {

    private E[] array;

    private int size;

    public GenericArray(int capacity) {
        array=(E[]) new Object[capacity];

        size=0;
    }

    public void add(int index, E e) {

    }

    public void addFirst(E e) {

    }

    public void addLast(E e) {

    }

    public E get(int index) {

        return array[index];
    }
}
