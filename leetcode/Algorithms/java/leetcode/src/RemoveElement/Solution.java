package RemoveElement;

import org.junit.Test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null && nums.length == 0) {
            return 0;
        }

        int count = 0;
        int start = -1;
        int end = nums.length - 1;
        int i = end;
        int j = end;
        while (i > -1) {
            while (j > -1 && nums[j] == val) {
                start = j;
                j--;
            }

            if (start != -1) {
                int dup = end - start + 1;
                count += dup;

                if (end != nums.length - 1) {
                    for (int k = start; k < nums.length - dup; k++) {
                        nums[k] = nums[++end];
                    }
                }
                start = -1;
            }

            while (j > -1 && nums[j] != val) {
                j--;
            }
            end = j;
            i = j;
        }
        return nums.length - count;
    }

    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //元素顺序可以更改
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }



    @Test
    public void test() {
        int[] nums1 = {0,1,2,2,3,0,4,2};
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int[] nums3 = {0,0,0,0,0,0,0,0};
        int[] nums4 = {0};
        int[] nums5 = {0,0,0,0,0,0,0,0};
        assert (removeElement(nums1, 2) == 5);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
        assert (removeElement(nums2, 0) == 6);
        assert (removeElement(nums3, 0) == 0);
        assert (removeElement(nums4, 0) == 0);
        assert (removeElement(nums5, 1) == 8);
    }
}
