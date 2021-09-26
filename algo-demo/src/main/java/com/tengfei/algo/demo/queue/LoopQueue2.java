package com.tengfei.algo.demo.queue;

/**
 * 循环队列。没有多余元素的方式
 * 注意：循环队列的两种遍历方式
 *
 * @param <E>
 */
public class LoopQueue2<E> implements Queue<E> {

    private E[] array;

    private int front, tail;

    private int size;

    public LoopQueue2() {
        this(10);
    }

    public LoopQueue2(int capacity) {
        array = (E[]) new Object[capacity];
        front = 0;
        size = 0;
        tail = 0;
    }

    @Override
    public void enqueue(E e) {
        //头接点和尾接点有一个元素差，当tail=front时说明队列已满，需要扩容
        if (tail == front && size != 0) {
            resize(array.length * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newArray = (E[]) new Object[newCapacity];
        //循环队列遍历1
        boolean firstLoop = true;
        for (int i = 0;( (i + front) % array.length != tail && size != 0)||firstLoop; i++) {
            firstLoop = false;
            newArray[i] = array[(front + i) % array.length];
        }
        array = newArray;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        //注意出队操作时，没有元素的情况处理
        if (size == 0) {
            throw new IllegalArgumentException("not element in queue");
        }

        //出队是从头节点出队
        E e = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;
        if (size == array.length / 4) {
            resize(array.length / 2);
        }
        return e;
    }

    @Override
    public E getFront() {
        return array[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("LoopQueue2 size:%d,length:%d,Front:[", size, array.length));
        //遍历方式2
        boolean firstLoop = true;
        for (int i = front; (i!= tail&& size!=0)|| firstLoop; i = (i + 1) % array.length) {
            firstLoop = false;
            sb.append(array[i]);
            if ((i + 1) % array.length != tail) {
                sb.append(",");
            }

        }
        sb.append("]");
        return sb.toString();
    }
}
