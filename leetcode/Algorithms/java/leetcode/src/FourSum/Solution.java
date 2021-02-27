package FourSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int tSum = nums[i] + nums[j];
                int lo = j + 1;
                int hi = n - 1;

                while (lo < hi) {
                    int sum = tSum + nums[lo] + nums[hi];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j],nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if (sum > target) {
                        hi--;
                    }
                    else {
                        lo++;
                    }
                }
            }
        }

        return res;
    }

}
