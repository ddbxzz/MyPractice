package FLPosInSortedArray;

import org.junit.Test;

public class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};

        if (nums == null) {
            return res;
        }
        if (nums.length == 1) {
            return (nums[0] == target) ? new int[]{0, 0} : res;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                getIndex(nums, mid, res);
                break;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return res;
    }

    private void getIndex(int[] nums, int idx, int[] res) {
        int i = idx;
        int j = idx;
        while (i > 0 && (nums[i] == nums[i - 1])) {
            i--;
        }
        while (j < nums.length - 1 && (nums[j] == nums[j + 1])) {
            j++;
        }
        res[0] = i;
        res[1] = j;
    }

    @Test
    public void test() {
        int[] nums = {5,7,7,8,8,10};
        int[] r = searchRange(nums, 6);
        System.out.println(r[0] + " " + r[1]);
    }
}
