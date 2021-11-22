package com.tengfei.algo.demo.search;

/**
 * 二分查找
 */
public class BinarySearch {


    public <E extends Comparable<E>> int search(E[] arr, E e) {
        return search(arr, 0, arr.length - 1, e);
    }

    private <E extends Comparable<E>> int search(E[] arr, int l, int r, E target) {

        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid].compareTo(target) == 0) {
            return mid;
        }
        if (arr[mid].compareTo(target) < 0) {
            return search(arr, mid + 1, r, target);
        }
        return search(arr, l, mid - 1, target);
    }

    /**
     * 在数组中找到大于target的最小值
     *
     * @param arr
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int upper(E[] arr, E target) {

        int l = 0, r = arr.length;
        //在arr[l,r]中找出目标值。
        while (l < r) {
            int mid = l + (r - l) / 2;
            //说明边界没有合适的元素。相等也不行
            if (arr[mid].compareTo(target) <= 0) {
                l = mid + 1;
            }
            //说明有合适的元素在左边界
            if (arr[mid].compareTo(target) > 0) {
                r = mid;
            }

        }

        //返回l,r都可以此时会相等
        return l;
    }

    /**
     * upper_ceil
     * 如果数组存在元素，返回最大索引。如果不存在返回upper
     * <p/>在数学中对浮点数的计算
     *
     * @param arr
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int ceil(E[] arr, E target) {
        int u = upper(arr, target);
        if (u - 1 > 0 && arr[u - 1] == target) {
            return u - 1;
        }
        return u;
    }


    /**
     * 查找比目标元素小的最大值的位置，无，则返回-1
     *
     * @param arr    有序数组
     * @param target 目标元素
     * @param <E>    可排序的元素
     * @return 目标元素位置下标。无，则返回-1
     */
    public static <E extends Comparable<E>> int lower(E[] arr, E target) {
        int l = -1, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            //arr[mid]>target时，arr[mid,r]的元素都不满足
            if (arr[mid].compareTo(target) < 0) {
                l = mid;

            } else {
                //<=target时，mid有可能是目标元素
                r = mid - 1;
            }
        }
        return l;
    }


    //lower_floor 存在返回最小索引，不存在返回lower
    public static <E extends Comparable<E>> int lowerFloor(E[] arr, E target) {
        int u = lower(arr, target);
        if (u + 1 < arr.length - 1 && arr[u + 1].compareTo(target) == 0) {
            return u + 1;
        }

        return u;
    }

    /**
     *  <=target的最大索引 upper_floor
     * @param arr
     * @param target
     * @param <E>
     * @return
     */
    public static <E extends Comparable<E>> int upperFloor(E[] arr, E target) {
        int l=-1,r= arr.length-1;

        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // 在 lower 中，这里是 data[mid].compareTo(target) < 0
            // 但是，对于 upper_floor 来说，在 data[mid] == target 的时候，有可能是解
            // 所以在等于的情况下，不能排除掉 data[mid] 的值，我们的搜索空间的变化，同样是 l = mid
            if (arr[mid].compareTo(target) <= 0) {
                l=mid;
            }else {
                r = mid - 1;
            }
        }

        return l;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 1, 2, 2, 4, 4};
        for (int i = 0; i < 6; i++) {
            int upper = lowerFloor(arr, i);
            System.out.println(i + "->lowerFloor = " + upper);
        }
    }
}
