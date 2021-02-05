package PathSum;

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
    //递归
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        return hasPathSum1(root.left, targetSum - root.val) ||
                hasPathSum1(root.right, targetSum - root.val);
    }

    //深度优先搜索(DFS)
    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }

        if (root.left != null && dfs(root.left, targetSum, sum)) {
            return true;
        }

        if (root.right != null && dfs(root.right, targetSum, sum)) {
            return true;
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum, 0);
    }


    //广度优先搜索(BFS)
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode tmpNode = queueNode.poll();
            int tmpVal = queueVal.poll();
            if (tmpNode.left == null && tmpNode.right == null) {
                if (tmpVal == targetSum) {
                    return true;
                }
                continue;
            }
            if (tmpNode.left != null) {
                queueNode.offer(tmpNode.left);
                queueVal.offer(tmpVal + tmpNode.left.val);
            }

            if (tmpNode.right != null) {
                queueNode.offer(tmpNode.right);
                queueVal.offer(tmpVal + tmpNode.right.val);
            }
        }
        return false;
    }
}
