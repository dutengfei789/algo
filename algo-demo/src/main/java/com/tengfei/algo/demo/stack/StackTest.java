package com.tengfei.algo.demo.stack;

public class StackTest {

    public static void main(String[] args) {

        Stack<Integer> stack = new LinkListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        System.out.println(stack);
        stack.pull();
        System.out.println(stack);
        stack.push(21);
        System.out.println(stack);


    }
}
