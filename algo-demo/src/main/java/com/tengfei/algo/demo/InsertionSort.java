package com.tengfei.algo.demo;

import java.util.Arrays;

/**
 * 插入排序
 * 时间复杂度: o(n^2)
 * 插入排序存在：内层循环提终止情况。元素本身是有序时，此时时间复杂度为o(n).
 * 对于近乎有序的数据处理使用插入排序
 */
public class InsertionSort {

    public static <E extends Comparable<E>> void sort2(E[] arr) {
//        printArray(arr);
//        System.out.println("------------------");
        //循环不变量
        for (int i = 0; i < arr.length; i++) {
//            for (int j = i; j -1>= 0; j--) {
//                if (arr[j-1].compareTo(arr[j]) > 0) {
//                    swap(arr, j, j-1);
//                } else {
//                    break;
//                }
//
//            }
            for (int j = i; j - 1 >= 0 && arr[j - 1].compareTo(arr[j]) > 0; j--) {
                swap(arr, j, j - 1);
            }
        }

//        printArray(arr);

    }

    /**
     * 插入排序优化
     * 利用中间值和前一个元素值小于当前值覆盖优化
     *
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            E t = arr[i];
            int j;
            //发现有更小的元素时，元素前移。将arr[i]插入到合适的位置
            for (j = i; j - 1 >= 0 && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            //拿比较的元素放在最小下标位置
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr,int l,int r) {
        for (int i = l; i <=r; i++) {
            E t = arr[i];
            int j;
            //发现有更小的元素时，元素前移。将arr[i]插入到合适的位置
            for (j = i; j - 1 >= l && arr[j - 1].compareTo(t) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            //拿比较的元素放在最小下标位置
            arr[j] = t;
        }
    }

    /**
     * 从后向前排序
     * @param arr
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort3(E[] arr){
        for (int i = arr.length-1; i >=0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j +1 <= arr.length-1 && arr[j].compareTo(arr[j + 1]) > 0; j++) {
                arr[j + 1] = arr[j];
            }
            arr[j] = t;
        }
    }

    private static <E extends Comparable<E>> void printArray(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr = " + arr[i]);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] dataSize = {10_000, 1000_000};
        for (int size : dataSize) {
            System.out.println("generate random array");
            Integer[] array = ArrayGenerate.generateRandomArray(size, size);
            Integer[] array2 = Arrays.copyOf(array, array.length);
            SortingHelper.sortTest("SelectionSort", array);
            SortingHelper.sortTest("InsertionSort", array2);
            System.out.println("------------");
            System.out.println("generate order array");
            array = ArrayGenerate.generateOrderArray(size);
            array2 = Arrays.copyOf(array, array.length);
            SortingHelper.sortTest("SelectionSort", array);
            SortingHelper.sortTest("InsertionSort", array2);

        }

    }
}
