package RotateImage;

import org.junit.Test;

public class Solution {
    //原地旋转
    public void rotate1(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
    }

    //用翻转代替旋  转水平轴翻转 + 主对角线翻转
    public void rotate2(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }


    @Test
    public void test() {
        int[][] m1 = {{1,2,3,4}, {4,5,6,7}, {7,8,9,10}, {2,5,6,9}};
        int[][] m = {{1,2,3,4,5}, {4,5,6,7,8}, {7,8,9,10,11}, {2,5,6,9,12}, {3,6,7,90,23}};
        rotate1(m);
/*        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }*/
    }
}
