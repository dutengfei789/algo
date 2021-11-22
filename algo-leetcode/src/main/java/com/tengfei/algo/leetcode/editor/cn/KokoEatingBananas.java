package com.tengfei.algo.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 题号：【875】爱吃香蕉的珂珂
 */
public class KokoEatingBananas{
  public static void main(String[] args) {
      int[] piles={3,6,7,11};
      int h=8;
       Solution solution = new KokoEatingBananas().new Solution();
      int i = solution.minEatingSpeed(piles, h);
      System.out.println(i);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        while (l < r) {
            //当出现只有2个最小元素时，l=mid+1,因此无需要再进行向上取整
            int mid = l + (r - l) / 2;
            //越往右，求得的用时越少
            if (eatingTime(piles, mid) <= h) {
                //说明此时的mid已经满足求解，但是为了找到更小的mid最用时尽可能多，需要在左边界找
                r = mid;
            }else {
                //说明左边界已经没有满足h，需要从mid+1位置找
                l = mid + 1;
            }
        }
        return l;

    }
      private int eatingTime(int[] piles, int k) {
          int res=0;
          for (int pile : piles) {
              res += ((pile + k - 1) / k);
          }
          return res;
      }


}


//leetcode submit region end(Prohibit modification and deletion)

}
