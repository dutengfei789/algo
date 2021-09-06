package com.tengfei.algo.demo.array;

public class ArrayTest {

    public static void main(String[] args) {
        GenericArray<Integer> arr = new GenericArray<Integer>(10);
        for (int i = 0; i < 10; i++) {
            arr.add(i);
        }
        System.out.println(arr);

        arr.addFirst(0);
        System.out.println(arr);

        arr.addLast(6);
        System.out.println(arr);

        arr.addElement(2, 1);
        System.out.println(arr);

        arr.removeIndex(1);
        System.out.println(arr);
    }
}
