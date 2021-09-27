package com.tengfei.algo.demo.link;

/**
 * 重点：
 * 1.链表的3种遍历方式
 * 2.接点的赋值问题。当前接点、前一个接点
 * 3. 增删改查时间复杂度为O(n)，只对链表头操作为O(1)，且不浪费空间
 * @param <E>
 */
public class LinkedList<E> {

    private int size;

    //虚拟头接点
    private Node dummyHead;

    private class Node {

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

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public LinkedList() {
        //初初化一个虚拟头节点
        dummyHead = new Node(null, null);
        size = 0;
    }



    public int gtSize() {
        return size;
    }

    //在链表中添加0-based位置的元素
    //注意点：添加元素时元素节点的连接情况
    //时间复杂度O(n)
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add fail,illegal index");
        }

//        if (index == 0) {
//            addFirst(e);
//        }else {
//            Node preNode = head;
//            for (int i = 0; i < index-1; i++) {
//                preNode = preNode.next;
//            }

//            Node node = new Node(e);
//            node.next = preNode.next;
//            preNode.next=node;

//            preNode.next=new Node(e, preNode.next);
//            size++;
//        }

        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = new Node(e, preNode.next);
        size++;

    }

    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head.e=e;
        //等同于上面
//        head = new Node(e, head);
//        size++;


        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("非法下标参数");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        //第二种遍历
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //修改指定下标的元素
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("非法下标参数");
        }
        //通过next获取到的是当前元素
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e=e;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("非法下标参数");
        }
        Node pre=dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node ret = pre.next;
        pre.next=ret.next;
        ret.next=null;
        size--;

        return ret.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur=cur.next) {
            res.append(cur.e + "->");
        }
        res.append("NULL");
        return res.toString();
    }
}
