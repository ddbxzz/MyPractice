package SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        int p1 = 0;
        int p2 = nums.length - 1;
        int c = 0;

        while (c <= p2) {
            if (nums[c] == 0) {
                int tmp = nums[c];
                nums[c] = nums[p1];
                nums[p1] = tmp;
                p1++;
                c++;
            }
            else if (nums[c] == 2) {
                int tmp = nums[c];
                nums[c] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            else {
                c++;
            }

        }
    }
}
