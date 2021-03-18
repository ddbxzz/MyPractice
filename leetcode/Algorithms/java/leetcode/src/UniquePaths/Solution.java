package UniquePaths;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //排列组合公式
    public int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int)ans;
    }

    //dp
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];

        /*
            int[] dp = new int[m];
    Arrays.fill(dp, 1);
    for (int j = 1; j < n; j++)
        for (int i = 1; i < m; i++)
            dp[i] += dp[i - 1];
    return dp[m - 1];

         */
    }

    //dfs
    public int uniquePaths3(int m, int n) {
        //return dfs(1, 1, m, n);
        return dfs1(1, 1, m, n, new HashMap<>());
    }
    private int dfs(int i, int j, int m, int n) {
        if (i > m || j > n) {
            return 0;
        }

        if (i == m || j == n) {
            return 1;
        }

        return dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
    }

    private int dfs1(int i, int j, int m, int n, Map<String, Integer> map) {
        if (i > m || j > n) {
            return 0;
        }

        if (i == m || j == n) {
            return 1;
        }

        String key = i + "*" + j;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int right = dfs1(i + 1, j, m, n, map);
        int down = dfs1(i , j + 1, m, n, map);
        map.put(key, right + down);

        return right + down;
    }
}
