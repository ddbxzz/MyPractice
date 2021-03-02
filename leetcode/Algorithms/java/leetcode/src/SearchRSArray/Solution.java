package SearchRSArray;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int n = nums.length;
        if (n == 1) {
            return (target == nums[0]) ? 0 : -1;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[n - 1]) {
                    l = mid + 1;
                }
                else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
