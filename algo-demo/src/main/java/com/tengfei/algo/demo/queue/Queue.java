package com.tengfei.algo.demo.queue;

/**
 * Queue队列
 * FIFO（First In First Out）
 * @param <E>
 */
public interface Queue<E> {

    /**
     * 入队操作
     */
    void enqueue(E e);

    /**
     * 出队操作
     * @return
     */
    E dequeue();

    /**
     * 获取元素
     * @return
     */
    E getFront();

    /**
     * 查询 队列元素个数
     * @return
     */
    int getSize();

    /**
     * 查询队列是否为空
     * @return
     */
    boolean isEmpty();
}
