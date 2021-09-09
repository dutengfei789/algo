package com.tengfei.algo.demo.stack;

import com.tengfei.algo.demo.array.GenericArray;

/**
 * 栈是一种后进先出的数据结构
 * LIFO(Last In First Out)
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E>{

    private GenericArray<E> array;

    public ArrayStack() {
        this.array = new GenericArray<>();
    }

    public ArrayStack(int capacity) {
        this.array = new GenericArray<>(capacity);
    }

    /**
     * 向队列中push一个元素
     * 时间复杂度为O(1)
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pull() {
        return array.removeIndex(array.getSize()-1);
    }

    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    @Override
    public boolean empty() {
        return array.isEmpty();
    }

    @Override
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("stack size:%d [", array.getSize()));
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] TOP");
        return sb.toString();
    }
}
