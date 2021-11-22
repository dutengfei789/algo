package com.tengfei.algo.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 题号：【1011】在 D 天内送达包裹的能力
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        int weight = solution.shipWithinDays(weights, 5);
        System.out.println("days = " + weight);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * weight和days成单调性，weight越大，days越小
         * 需要找到days(weight)<=days的最小载重量
         *
         * @param weights
         * @param days
         * @return
         */
        public int shipWithinDays(int[] weights, int days) {

            //先算出传送带的边界
            int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
            while (l < r) {
                int mid = l + (r - l) / 2;
                // 如果传送带运载能力是 mid，运完货物需要的天数小于等于 D
                // 那么 mid 就是一个可能的解，但是，我们还要找，看有没有更小的解
                // 所以，调整右边界，r = mid。
                // 注意，mid 要包含在搜索范围里，因为 mid 是问题的解
                if (days(weights, mid) <= days) {
                    r = mid;
                } else {
                    // 在决定好搜索空间的调整方式后，我们可以试验一下，如果 l， r 相邻，是否会出现死循环？
                    // 在这个例子中，因为下取整以后，在 l 和 r 相临时，mid 为 l。而对 l 的更新，是 mid + 1
                    // 所以保证了在这种情况下，搜索空间会继续缩小，不会产生死循环
                    // 因此，使用下取整来计算 mid 是可以的
                    l = mid + 1;
                }
            }


            return l;

        }

        private int days(int[] weights, int k) {
            int cur = 0, res = 0;
            for (int weight : weights) {
                //如果当前的重量加上当前的货物没有超过 k，把当前货物重量加在 cur 上
                if (cur + weight <= k) {
                    cur += weight;
                } else {
                    res++;
                    cur = weight;
                }
            }
            // 最后还要做一次 res ++，因为在这里 cur 肯定不为零，还记录着最后一天需要运送的货物重量
            // 最后一天，要加到 res 中，所以 res ++
            res++;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
