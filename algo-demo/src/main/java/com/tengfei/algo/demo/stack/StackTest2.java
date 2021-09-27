package com.tengfei.algo.demo.stack;

import java.util.Random;

public class StackTest2 {
    public static void main(String[] args) {
        int countMod=10_000;
        Stack<Integer> arrayStack = new ArrayStack<>();
        double time1 = test(arrayStack, countMod);
        System.out.println("arrayStack:" + time1 + "s");

        Stack<Integer> listStack = new LinkListStack<>();
        double time2 = test(listStack, countMod);
        System.out.println("listStack:" + time2 + "s");

    }

    public static double test(Stack<Integer> stack, int count) {
        long start = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pull();
        }

        long end = System.nanoTime();
        return (end-start)/1_000_000_000.0;
    }
}
