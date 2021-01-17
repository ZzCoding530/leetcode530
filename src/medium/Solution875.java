package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/17
 * @description:
 */

public class Solution875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int min = 1;
            int max = maxV(piles);
            //我们要找符合条件的最小值
            while (min < max) {
                int mid = (min + max) / 2;
                if (canEatFinish(piles, H, mid)) {//如果能吃完，说明可能还可以吃的更慢
                    max = mid;//这里要注意，因为是能吃完，所以mid也符合条件
                } else {//不能吃完，说明需要吃的更快一点
                    min = mid + 1;//这里要注意，因为不能吃完，所以mid不符合条件
                }
            }
            return min;
        }

        /**
         * 能否在H小时以速度k吃完香蕉
         *
         * @param piles 香蕉
         * @param H     小时
         * @param K     速度
         * @return 能否吃完
         */
        private boolean canEatFinish(int[] piles, int H, int K) {
            int h = 0;
            for (int v : piles) {
                h += (v - 1) / K + 1;
            }
            return h <= H;
        }


        /**
         * 找到香蕉堆中最大的值
         *
         * @param piles
         * @return
         */
        private int maxV(int[] piles) {
            int temp = 0;
            for (int v : piles) {
                temp = Math.max(v, temp);
            }
            return temp;
        }
    }

}
