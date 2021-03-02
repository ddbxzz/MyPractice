package NextPermutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    private void reverse(int[] nums, int start) {
        int lo = start;
        int hi = nums.length - 1;
        while (lo < hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
}
