package Search2DMatrix;

import java.util.Arrays;

public class Solution {
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (target <= matrix[i][n - 1]) {
                if (Arrays.binarySearch(matrix[i], target) >= 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = m * n - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == matrix[mid / n][mid % n]) {
                return true;
            }
            else if (target < matrix[mid / n][mid % n]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }

}
