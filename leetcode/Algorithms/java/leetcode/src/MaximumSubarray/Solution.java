package MaximumSubarray;

import org.junit.Test;

public class Solution {
    //普通循环暴力求解
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = i; j < nums.length; j++) {
                tmpSum += nums[j];
                if (tmpSum > maxSum) {
                    maxSum = tmpSum;
                }
            }
        }

        return maxSum;
    }

    //分治
    private int maxsubArrayInner(int[] nums, int lo, int hi) {
        if (lo == hi - 1) {
            return nums[lo];
        }

        int mid = (lo + hi) / 2;
        int maxLeftSum = maxsubArrayInner(nums, lo, mid);
        int maxRightSum = maxsubArrayInner(nums, mid, hi);

        int leftSum = nums[mid - 1];
        int tmpSum = 0;
        for (int i = mid - 1; i >= lo; i--) {
            tmpSum += nums[i];
            if (leftSum < tmpSum) {
                leftSum = tmpSum;
            }
        }

        int rightSum = nums[mid];
        tmpSum = 0;
        for (int i = mid; i < hi; i++) {
            tmpSum += nums[i];
            if (rightSum < tmpSum) {
                rightSum = tmpSum;
            }
        }

        return Math.max(leftSum + rightSum, Math.max(maxLeftSum, maxRightSum));
    }
    public int maxSubArray2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return maxsubArrayInner(nums, 0, nums.length);
    }

    //在线
    public int maxSubArray3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        int tmpSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tmpSum += nums[i];

            if (tmpSum > maxSum) {
                maxSum = tmpSum;
            }

            if (tmpSum < 0) {
                tmpSum = 0;
                continue;
            }
        }

        return maxSum;
    }

    @Test
    public void test() {
        int[] nums1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};
        int[] nums4 = {-2, 1};
        int[] nums5 = {-2,-1};
        assert (maxSubArray3(nums1) == maxSubArray1(nums1));
        assert (maxSubArray3(nums2) == maxSubArray1(nums2));
        assert (maxSubArray3(nums3) == maxSubArray1(nums3));
        assert (maxSubArray3(nums4) == maxSubArray1(nums4));
        assert (maxSubArray3(nums5) == maxSubArray1(nums5));
    }
}
