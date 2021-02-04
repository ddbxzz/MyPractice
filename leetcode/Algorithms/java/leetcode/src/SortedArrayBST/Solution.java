package SortedArrayBST;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private TreeNode insert(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }
        TreeNode root = new TreeNode();
        int mid = (lo + hi) / 2;
        root.val = nums[mid];
        root.left = insert(nums, lo, mid);
        root.right = insert(nums, mid + 1, hi);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return insert(nums, 0, nums.length);
    }
}
