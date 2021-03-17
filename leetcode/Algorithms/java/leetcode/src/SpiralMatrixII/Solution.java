package SpiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;

        int idx = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                result[up][i] = idx;
                idx++;
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                result[i][right] = idx;
                idx++;
            }
            right--;
            if (right < left) break;
            for (int i = right; i >= left; i--) {
                result[down][i] = idx;
                idx++;
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                result[i][left] = idx;
                idx++;
            }
            left++;
            if (left > right) break;
        }
        return result;
    }
}
