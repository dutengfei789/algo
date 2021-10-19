package com.tengfei.algo.demo;

import com.tengfei.algo.demo.sort.MergeSort;

public class SortingHelper {

    public static  <E extends Comparable<E>> boolean isSorted(E[] array) {
        //从1开始
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1].compareTo(array[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] array) {
        long start = System.nanoTime();
        if (sortName.equals("SelectionSort")) {
            SelectionSort.sort(array);
        } else if (sortName.equals("SelectionSort2")) {
            SelectionSort.sortByEnd(array);
        } else if (sortName.equals("InsertionSort")) {
            InsertionSort.sort(array);
        }else if (sortName.equals("InsertionSort2")) {
            InsertionSort.sort2(array);
        }else if (sortName.equals("InsertionSort3")) {
            InsertionSort.sort3(array);
        }else if (sortName.equals("mergeSort")) {
            MergeSort.sort(array);
        }else if (sortName.equals("mergeSort2")) {
            MergeSort.sort2(array);
        }
        if (!SortingHelper.isSorted(array)) {
            throw new RuntimeException(sortName + " failed");
        }
        long end = System.nanoTime();
        double time = (end - start )/ 1000_000_000.0D;
        System.out.println(String.format("sortName:%s,n=%d,time=%f", sortName, array.length, time));
    }


}
