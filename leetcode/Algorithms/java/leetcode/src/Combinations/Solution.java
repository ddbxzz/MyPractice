package Combinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k > n) {
            return res;
        }

        Stack<Integer> path = new Stack<>();
        //dfs1(n, k, 1, path, res);
        dfs2(n, k, 1, path, res);
        return res;
    }

    private void dfs1(int n, int k, int index, Stack<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n - k + path.size() + 1; i++) {
            path.push(i);
            dfs1(n, k, i + 1, path, res);
            path.pop();
        }
    }

    private void dfs2(int n, int k, int start, Stack<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (start > n - k + 1) {
            return;
        }

        dfs2(n, k, start + 1, path, res);

        path.push(start);
        dfs2(n, k - 1, start + 1, path, res);
        path.pop();
    }
}
