package com.tengfei.algo.demo.stack;

public interface Stack<E>{

    void push(E e);

    E pull();

    E peek();

    boolean empty();

    int getCapacity();

}
