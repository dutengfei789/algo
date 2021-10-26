package com.tengfei.algo.demo.sort;

import com.tengfei.algo.demo.ArrayGenerate;
import com.tengfei.algo.demo.InsertionSort;
import com.tengfei.algo.demo.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序。核心思想是求出数组的的中间值，进行排序
 * 时间复杂度：
 * 当数组为完全有序数组快排之后为:O(n^2)。递归深度O(n)
 */
public class QuickSort {

    private static final Random random=new Random();

    public static  <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static  <E extends Comparable<E>> void sort(E[] arr,int l,int r) {

        if (r - l <= 15) {
            // 使用 Insertion Sort 优化
            InsertionSort.sort(arr, l, r);
            // 注意，这里要 return！
            return;
        }

        if (l >= r) {
            return;
        }
        //p为最终排好顺序的元素下标
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p + 1, r);
    }

    /**
     * 假定数组的第一个元素v为中间元素，然后对整个数组进行遍历分割
     * 循环不变量：arr[l+1...j]<v ;arr[j+1...i]>=v
     * @param arr 待排序的数组
     * @param l 数组第一个元素下标
     * @param r 数组末尾元素下标
     * @param <E> 可排序的元素
     * @return 中间元素下标位置
     */
    private static  <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        //为了避免对完全有序数组排序时，递归过深，采用随机一个下标做为起始数据，可以避免递归过深
//        int p = l + random.nextInt(r - l + 1);
//        swap(arr, l, p);
        swap(arr, l, (r + l) / 2);
        //j表示小于v的数组最末尾一个元素下标
        int j = l;
        for (int i = l+1; i <= r; i++) {
            //和不变量l对比
            if (arr[i].compareTo(arr[l]) < 0) {
                j++;
                swap(arr, j, i);
            }
        }
        //最终要交换一下末尾元素和起始元素位置。将v放于两个数组之间
        swap(arr, l, j);
        return j;
    }

    private static <E extends Comparable<E>> void swap(E[] arr, int j, int i) {
        E temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int n = 1_000_000;

        Integer[] array = ArrayGenerate.generateRandomArray(n, n);
        Integer[] array2 = Arrays.copyOf(array, array.length);
//        Integer[] array = new Integer[]{1, 4, 4, 0, 3};
        SortingHelper.sortTest("mergeSort2", array);
        SortingHelper.sortTest("quickSort", array2);
    }

}
