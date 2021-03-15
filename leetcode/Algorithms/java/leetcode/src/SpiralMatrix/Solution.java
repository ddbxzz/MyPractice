package SpiralMatrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            if (up++ >= down) break;
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            if (right-- <= left) break;
            for (int i = right; i >= left; i--) {
                result.add(matrix[down][i]);
            }
            if (down-- <= up) break;
            for (int i = down; i >= up; i--) {
                result.add(matrix[i][left]);
            }
            if (left++ >= right) break;
        }

        return result;
    }

    @Test
    public void test() {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        List<Integer> result = spiralOrder(matrix);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
