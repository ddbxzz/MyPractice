package SameTree;

import org.junit.Test;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            if (q == null) {
                return true;
            }
            return false;
        }

        if (q == null) {
            return false;
        }

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode tmp1 = pQueue.poll();
            TreeNode tmp2 = qQueue.poll();

            if (tmp1 == null || tmp2 == null || tmp1.val != tmp2.val) {
                return false;
            }

            if (tmp1.left != null || tmp2.left != null) {
                pQueue.add(tmp1.left);
                qQueue.add(tmp2.left);
            }


            if (tmp1.right != null || tmp2.right != null) {
                pQueue.add(tmp1.right);
                qQueue.add(tmp2.right);
            }

        }

        return pQueue.isEmpty() && qQueue.isEmpty();
    }

    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    @Test
    public void test() {

    }
}
