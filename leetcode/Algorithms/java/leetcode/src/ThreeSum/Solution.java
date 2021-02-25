package ThreeSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        int n = nums.length;

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int lo = 0; lo < n; lo++) {
            if (nums[lo] > 0) {
                break;
            }
            if (lo > 0 && nums[lo] == nums[lo - 1]) {
                continue;
            }
            int mid = lo + 1;
            int hi = n -1;
            while (mid < hi) {
                int sum = nums[lo] + nums[mid] + nums[hi];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[lo], nums[mid], nums[hi]));
                    while (mid < hi && nums[mid] == nums[mid + 1]) mid++;
                    while (mid < hi && nums[hi] == nums[hi - 1]) hi--;
                    mid++;
                    hi--;
                }
                else if (sum < 0) {
                    mid++;
                }
                else{
                    hi--;
                }
            }
        }
        return res;

    }
}
