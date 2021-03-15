package JumpGame;

public class Solution {
    //如果一个位置能够到达，那么这个位置左侧所有位置都能到达

    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int maxk = 0;
        for (int i = 0; i <= maxk; i++) {
            maxk = Math.max(maxk, i + nums[i]);
            if (maxk >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
