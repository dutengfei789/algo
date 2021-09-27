package com.tengfei.algo.demo.stack;

import com.tengfei.algo.demo.link.LinkedList;

public class LinkListStack<E> implements Stack<E>{

    private LinkedList<E> list;

    public LinkListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pull() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public int getCapacity() {
        return list.gtSize();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("stack,top:");
        str.append(list);
        return str.toString();
    }
}
