package ThreeSumCloset;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];
        int delta = Math.abs(sum - target);
        for (int lo = 0; lo < n - 2; lo++) {
            if (lo > 0 && nums[lo] == nums[lo -1]) {
                continue;
            }
            int mid = lo + 1;
            int hi = n - 1;

            while (mid < hi) {
                int tmpSum = nums[lo] + nums[mid] + nums[hi];
                if (tmpSum == target) {
                    return tmpSum;
                }
                int tmpDelta = Math.abs(target - tmpSum);
                if (tmpDelta < delta) {
                    delta = tmpDelta;
                    sum = tmpSum;
                }
                if (tmpSum > target) {
                    while (mid < hi && nums[hi - 1] == nums[hi]) hi--;
                    hi--;
                }
                if (tmpSum < target) {
                    while (mid < hi && nums[mid + 1] == nums[mid]) mid++;
                    mid++;
                }
            }
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums1 = {1,1,-1,-1,3};
        int target1 = -1;

        int[] nums2 = {1,1,1,0};
        int target2 = -100;

        int[] nums3 = {0,2,1,-3};
        int target3 = 1;

        int[] nums4 = {1,1,-1,-1,3};
        int target4 = -1;
        System.out.println(threeSumClosest(nums1, target1));
        System.out.println(threeSumClosest(nums2, target2));
        System.out.println(threeSumClosest(nums3, target3));
        System.out.println(threeSumClosest(nums4, target4));
    }
}
