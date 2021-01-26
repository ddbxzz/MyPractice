package RemoveArrayDuplicates;

import org.junit.Test;

public class Soution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int start = 0;
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[start] != nums[i]) {
                nums[count++] = nums[start];
                start = i;
            }
        }
        nums[count++] = nums[start];
        return count;
    }

    @Test
    public void test() {
        int[] nums1 = {0,0,1,1,1,2,2,3,3,4};
        int[] nums2 = {1,1,2};
        int[] nums3 = {3};
        assert (removeDuplicates(nums1) == 5);

    }
}
