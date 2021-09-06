package com.tengfei.algo.demo;

import java.util.Random;

public class ArrayGenerate {

    /**
     * 生成指定长度的数组
     * @param n 数据长度
     * @return
     */
    public static Integer[] generateOrderArray(int n) {

        Integer[] array = new Integer[n];

        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }


    /**
     * 生成指定长度，在一定范围的数组
     * @param n
     * @param bound
     * @return
     */
    public static Integer[] generateRandomArray(int n,int bound) {
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}
