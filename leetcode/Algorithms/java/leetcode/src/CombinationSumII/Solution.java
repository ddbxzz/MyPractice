package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }

        Stack<Integer> path = new Stack<>();

        Arrays.sort(candidates);
        dfs(result, candidates, 0, target, path);

        return result;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int start, int target, Stack<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] < 0) {
                break;
            }

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.push(nums[i]);
            dfs(res, nums, i + 1, target - nums[i], path);
            path.pop();
        }
    }
}
