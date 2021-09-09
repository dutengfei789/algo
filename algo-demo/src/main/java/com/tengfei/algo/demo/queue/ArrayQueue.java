package com.tengfei.algo.demo.queue;

import com.tengfei.algo.demo.array.GenericArray;

public class ArrayQueue<E> implements Queue<E>{

    private GenericArray<E> array;

    public ArrayQueue() {
        array = new GenericArray<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new GenericArray<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }


    @Override
    public E dequeue() {
        return array.removeIndex(0);
    }

    /**
     * 注意：
     * 出队操作的时间复杂度为O(n)，其它方法复杂度为O(1)
     * @return
     */
    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Queue Front[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if( i != array.getSize() - 1){
                sb.append(",");
            }

        }
        sb.append("]Last");
        return sb.toString();
    }
}
