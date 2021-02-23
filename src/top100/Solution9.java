package top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/2/23
 * @description: 全排列
 */

public class Solution9 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        back(nums, res, new ArrayList<Integer>(), used);
        return res;

    }

    private void back(int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp, boolean[] used) {

        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            tmp.add(nums[i]);
            back(nums, res, tmp, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }


    }


}
