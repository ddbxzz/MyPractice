package SymmetricTree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    private boolean isSame(TreeNode lNode, TreeNode rNode) {
        if (lNode == null && rNode == null) {
            return true;
        }
        if (lNode == null || rNode == null) {
            return false;
        }

        if (lNode.val != rNode.val) {
            return false;
        }

        return isSame(lNode.left, rNode.right) && isSame(rNode.left, lNode.right);
    }
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSame(root.left, root.right);
    }

    //迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null) {
                continue;
            }

            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }

            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    @Test
    public void test() {
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add(new TreeNode(5));
        arrayList.add(new TreeNode(5));
        TreeNode[] treeNodes = arrayList.toArray(new TreeNode[arrayList.size()]);
        System.out.println(treeNodes.length);
    }
}
