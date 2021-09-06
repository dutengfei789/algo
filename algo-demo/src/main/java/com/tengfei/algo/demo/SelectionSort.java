package com.tengfei.algo.demo;

import com.tengfei.algo.demo.array.GenericArray;
import com.tengfei.algo.demo.entity.Student;


/**
 * 选择排序
 */
public class SelectionSort {

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

    public static <E extends Comparable<E>> void sortByEnd(E[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (arr[maxIndex].compareTo(arr[j]) < 0) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int n = 4;
        Integer[] array = ArrayGenerate.generateRandomArray(n, n);
        SortingHelper.sortTest("SelectionSort2", array);
        for (int i = 0; i <array.length; i++) {
            System.out.println("array = " + array[i]);
        }

    }

}
