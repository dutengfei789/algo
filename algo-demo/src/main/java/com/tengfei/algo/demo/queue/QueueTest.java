package com.tengfei.algo.demo.queue;

public class QueueTest {

    public static void main(String[] args) {
//        Queue<Integer> queue = new ArrayQueue<>();
        Queue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
