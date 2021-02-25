package ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int result = 0;
        while (lo < hi) {
            int tmp = (hi - lo) * Math.min(height[lo], height[hi]);
            if (result < tmp) {
                result = tmp;
            }
            if (height[lo] <= height[hi]) {
                lo++;
            }
            else {
                hi--;
            }
        }
        return result;
    }
}
