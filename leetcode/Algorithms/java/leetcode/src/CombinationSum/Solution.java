package CombinationSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null ) {
            return result;
        }
        Stack<Integer> path = new Stack<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, result, path);
        return result;
    }

    private void dfs(int[] candidates, int idx, int target, List<List<Integer>> res, Stack<Integer> path) {
        if (idx == candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            path.push(candidates[i]);
            dfs(candidates, i, target - candidates[i], res, path);
            path.pop();
        }
    }
}
