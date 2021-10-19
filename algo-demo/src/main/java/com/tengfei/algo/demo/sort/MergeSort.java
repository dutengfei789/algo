package com.tengfei.algo.demo.sort;

import com.tengfei.algo.demo.ArrayGenerate;
import com.tengfei.algo.demo.SortingHelper;

import java.util.Arrays;

/**
 * 合并排序
 */
public class MergeSort {


    public MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void mergeSort(E[] arr, int l, int r) {

        //最基本元素处理
        if (l >= r) {

            return;
        }


//       使用加法可能造成整形溢出
//        int mid=(l+r)/2;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid].compareTo(arr[mid+1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    private static StringBuilder getStr(int i) {
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < i; j++) {
            str.append("-");
        }
        return str;
    }


    /**
     * 将arr中2个有序数据合并排序
     *
     * @param arr 需要合并的数组
     * @param l   合并的数据开始下标
     * @param mid 中间下标
     * @param r   结束下标
     * @param <E> 传入的元素类型
     */
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
//        printArray(arr, l, r);
        //数据copy为左开右闭的工具类
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i++;
            } else if (temp[i-l].compareTo(temp[j-l]) >= 0) {
                arr[k] = temp[j - l];
                j++;
            } else {
                arr[k] = temp[i - l];
                i++;
            }


        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        E[] temp = Arrays.copyOf(arr, arr.length);
        mergeSort2(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void mergeSort2(E[] arr, int l, int r,E[] temp) {

        //最基本元素处理
        if (l >= r) {
            return;
        }


//       使用加法可能造成整形溢出
//        int mid=(l+r)/2;
        int mid = l + (r - l) / 2;
        mergeSort2(arr, l, mid,temp);
        mergeSort2(arr, mid + 1, r,temp);
        if (arr[mid].compareTo(arr[mid+1]) > 0) {
            merge2(arr, l, mid, r,temp);
        }
    }




    /**
     * 将arr中2个有序数据合并排序
     *
     * @param arr 需要合并的数组
     * @param l   合并的数据开始下标
     * @param mid 中间下标
     * @param r   结束下标
     * @param <E> 传入的元素类型
     */
    private static <E extends Comparable<E>> void merge2(E[] arr, int l, int mid, int r,E[] temp) {
//        printArray(arr, l, r);
        //本次只会创建一个数组，可以节约内存空间
        System.arraycopy(arr, l, temp, l, r - l + 1);
        int i = l;
        int j = mid + 1;

        for (int k = l; k <= r; k++) {

            if (i > mid) {
                arr[k] = temp[j];
                j++;
            } else if (j > r) {
                arr[k] = temp[i];
                i++;
            } else if (temp[i].compareTo(temp[j]) >= 0) {
                arr[k] = temp[j];
                j++;
            } else {
                arr[k] = temp[i];
                i++;
            }


        }
    }



    private static <E extends Comparable<E>> void printArray(E[] arr, int l, int r){

        StringBuilder str = getStr(r - l + 1);
        while (l <= r) {
            str.append(arr[l]);
            if (l < r) {
                str.append(",");
            }
            l++;
        }
        System.out.println(str);

    }

    public static void main(String[] args) {
        int n = 5_000_000;

        Integer[] array = ArrayGenerate.generateRandomArray(n, n);
        Integer[] array2 = Arrays.copyOf(array, array.length);
//        Integer[] array = new Integer[]{1, 4, 4, 0, 3};
        SortingHelper.sortTest("mergeSort", array);
        SortingHelper.sortTest("mergeSort2", array2);
    }
}
