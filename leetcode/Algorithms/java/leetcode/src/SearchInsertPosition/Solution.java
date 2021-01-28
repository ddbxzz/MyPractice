package SearchInsertPosition;

import org.junit.Test;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        if (target < nums[start]) {
            return start;
        }

        if (target > nums[end - 1]) {
            return end;
        }

        while (start < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return start;
    }

    @Test
    public void test() {
        int[] nums1 = {1,3,5,6};
        int[] nums2 = {1,3};
        assert (searchInsert(nums1, 2) == 1);
        assert (searchInsert(nums1, 0) == 0);
        assert (searchInsert(nums2, 2) == 1);
        assert (searchInsert(nums1, 7) == 4);
    }
}
