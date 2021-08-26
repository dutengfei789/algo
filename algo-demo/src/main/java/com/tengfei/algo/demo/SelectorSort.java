package com.tengfei.algo.demo;

import com.tengfei.algo.demo.entity.Student;

import java.util.Comparator;

/**
 * 选择排序
 */
public class SelectorSort {

    public static <E extends Comparable> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex].compareTo(arr[j]) > 0) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        Integer[] arr = {3, 4, 6, 2, 1, 5};
        Student s1 = new Student("张三", 20);
        Student s2 = new Student("李四", 10);
        Student s3 = new Student("王五", 80);
        Student s4 = new Student("赵六", 19);
        Student[] arr = {s1, s2, s3, s4};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i = " + arr[i]);
        }

    }

}
