package com.tengfei.algo.demo.queue;

public class LinkListQueue<E> implements Queue<E> {

    private Node front,tail;

    private int size;

    private class Node{
        private E e;
        private Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    //尾入队
    @Override
    public void enqueue(E e) {

        Node node = new Node(e);
        //tail为空，说明队首也为空
        if (tail == null) {
            tail=node;
            front = node;
        }else {
            tail.next = node;
            tail=node;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (front == null) {
            throw new IllegalArgumentException("队列为空，不能完成出队操作！");
        }
        Node retNode = front;
        front=retNode.next;
        retNode.next = null;
        if (size == 1) {
            tail = null;
        }
        size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        return front.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("queue,front:[");
        Node cur=front;
        while (cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL]tail");
        return res.toString();
    }

}
