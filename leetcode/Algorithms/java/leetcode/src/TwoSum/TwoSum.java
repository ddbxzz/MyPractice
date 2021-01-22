package TwoSum;

import org.junit.Test;

import java.util.HashMap;

public class TwoSum {
    //暴力遍历
    public int[] twoSum1(int[] nums, int target) {
        int[] res = {-1, -1};

        if (nums.length < 2) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
//        throw new IllegalArgumentException("No two sum solution");
        return res;
    }

    //哈希映射
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }

    @Test
    public void test1() {
        int[] nums = {2,7,11,15};
        int[] res = twoSum2(nums, 9);
        System.out.println(res[0] + " , " + res[1]);
    }

    @Test
    public void test2() {
        int[] nums = {3, 2, 4};
        int[] res = twoSum2(nums, 6);
        System.out.println(res[0] + " , " + res[1]);
    }
}
