package Subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }

        Stack<Integer> path = new Stack<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, res, 0, i, path);
        }

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> result, int index, int size, Stack<Integer> path) {
        if (size == 0) {
            result.add(new ArrayList<>());
            return;
        }

        if (size == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, result, i + 1, size, path);
            path.pop();
        }
    }


    //迭代法实现子集枚举 bit
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> t = new ArrayList<>();
        int len = nums.length;
        for (int mask = 0; mask < (1 << len); mask++) {
            t.clear();

            for (int i = 0; i < len; i++) {
                if ((mask & (1 << i)) != 0) {
                    t.add(nums[i]);
                }
            }

            res.add(new ArrayList<>(t));
        }
        return res;
    }
}
