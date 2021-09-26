package com.tengfei.algo.demo.queue;

/**
 * 双端队列，可以从两端添加或删除元素的队列
 * <p>
 * double ended queue
 * <p>
 * addFirst/addLast
 * removeFirst/removeFirst
 *
 * @param <E>
 */
public class Deque<E> implements Queue<E> {

    private int front, tail;

    private int size;

    private E[] array;

    public Deque() {
        this(10);
    }

    public Deque(int capacity) {
        array = (E[]) new Object[capacity + 1];
    }


    @Override
    public void enqueue(E e) {
        if (array.length / 2 == size) {
            resize((array.length - 1) * 2);
        }
        array[tail] = e;
        tail = (tail + 1) % array.length;
        size++;

    }

    private void resize(int capacity) {
        E[] newArray = (E[]) new Object[capacity + 1];

        for (int i = 0; (front + i) % array.length != tail; i = (i + 1) % array.length) {
            newArray[i] = array[(front + i) % array.length];
        }
        front = 0;
        tail = size;
        array = newArray;
    }

    @Override
    public E dequeue() {

        E e = array[front];
        array[front] = null;
        front = (front + 1) % array.length;
        size--;

        if (array.length / 4 == size) {
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

    public void addFirst(E e) {

        if (array.length - 1 == size) {
            resize(array.length * 2);
        }

        if (front == 0) {
            front = array.length - 1;
        } else {
            front = (front - 1) % array.length;
        }

        array[front] = e;
        size++;

    }


    public void addLast(E e) {
        enqueue(e);
    }

    public E removeLast() {
        if (tail == 0) {
            tail = array.length - 1;
        } else {
            tail = (tail - 1) % array.length;
        }
        E e = array[tail];
        array[tail] = null;
        size--;
        return e;
    }

    public E removeFirst() {
        return dequeue();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("dequeue,size:%d,length:%d,front[", size, array.length - 1));
        for (int i = front; i != tail; i = (i + 1) % array.length) {
            sb.append(array[i]);
            if ((i + 1) % array.length != tail) {
                sb.append(",");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
}
