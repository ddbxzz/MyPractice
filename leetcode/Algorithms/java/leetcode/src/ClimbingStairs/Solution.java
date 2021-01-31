package ClimbingStairs;

import org.junit.Test;

public class Solution {
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs1(n - 1) + climbStairs1(n -2);
    }

    //动态规划
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int sum = 0;
        int f = 1;
        int g = 2;
        for (int i = 3; i <= n; i++) {
            sum = f + g;
            f = g;
            g = sum;
        }
        return sum;
    }

    //矩阵快速幂
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[][] m = {{1, 1}, {1, 0}};

        int[][] res = quicMatrixPow(m, n -2);
        return res[0][0] * 2 + res[0][1];
    }

    private int[][] quicMatrixPow(int[][] m, int k) {
        int[][] res = {{1, 0},{0, 1}};

        while (k > 0) {
            if ((k & 1) == 1) {
                res = multiply(res, m);
            }
            m = multiply(m, m);
            k >>= 1;
        }

        return res;
    }

    private int[][] multiply(int[][] m, int[][] n) {
        int[][] res = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = m[i][0]*n[0][j] + m[i][1]*n[1][j];
            }
        }
        return res;
    }

    @Test
    public void test() {
        assert  (climbStairs3(45) == climbStairs2(45));
    }
}
