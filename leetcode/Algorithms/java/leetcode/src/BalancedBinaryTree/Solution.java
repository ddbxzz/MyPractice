package BalancedBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

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
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        //return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (Math.abs(height(tmp.left) - height(tmp.right)) > 1) {
                return false;
            }
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return true;
    }

    private int height1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight, rightHeight;
        if ((leftHeight = height1(root.left)) == -1 ||
                (rightHeight = height1(root.right)) == -1 ||
                 Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced1(TreeNode root) {
        return height1(root) != -1;
    }
}
