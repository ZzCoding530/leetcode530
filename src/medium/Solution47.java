package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/4/11
 * @description: 全排列2
 */

public class Solution47 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> resList = new LinkedList<>();
        if (len == 0) {
            return resList;
        }

        boolean[] used = new boolean[len];

        List<Integer> eachList = new LinkedList<>();
        dfs(len, 0, used, nums, eachList, resList);

        return resList;
    }


    private void dfs(int len, int depth, boolean[] used, int[] nums, List<Integer> eachList, List<List<Integer>> resList) {
        if (len == depth) {
            resList.add(new ArrayList<>(eachList));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            eachList.add(nums[i]);
            used[i] = true;


            dfs(len, depth + 1, used, nums, eachList, resList);

            used[i] = false;
            eachList.remove(eachList.size() - 1);
        }

    }
}
