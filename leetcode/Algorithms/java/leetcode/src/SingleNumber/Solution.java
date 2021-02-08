package SingleNumber;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    //map
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = (count == null) ? 1 : count + 1;
            map.put(i, count);
        }

        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    //set
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            }
            else {
                set.add(i);
            }
        }

        return (int)set.toArray()[0];
    }

    //异或!!!!!!
    public int singleNumber3(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }


    @Test
    public void test() {
        int[] nums = {4,1,2,1,2};
        int res = singleNumber2(nums);
        System.out.println("----");
        System.out.println(res);
    }
}
