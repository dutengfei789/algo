package com.tengfei.algo.demo.queue;

import java.util.Random;

public class QueueTest2 {

    public static void main(String[] args) {
        int optCount=1_000_000;
//        Queue<Integer> arrayQueue = new ArrayQueue<>();
//        double time1 = testQueue(arrayQueue, optCount);
//        System.out.println("arrayQueue:" + time1 + "s");

        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, optCount);
        System.out.println("loopQueue:" + time2 + "s");

        Queue<Integer> linkListQueue = new LinkListQueue<>();
        double time3 = testQueue(loopQueue, optCount);
        System.out.println("linkListQueue:" + time3 + "s");

    }

    public static double testQueue(Queue<Integer> queue, int count) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        long end = System.nanoTime();

        return (end-start)/100_000_000.0;
    }
}
