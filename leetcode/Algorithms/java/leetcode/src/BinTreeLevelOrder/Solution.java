package BinTreeLevelOrder;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ilist = new LinkedList<>();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                ilist.add(tmp.val);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                size--;
            }
            list.add(0, ilist);
        }

        return list;
    }



    //DFS
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        ArrayList<List<Integer>> list = new ArrayList<>();

        if (root == null) {
            return list;
        }
        int index = 1;

        dfs(root, list, index);
        Collections.reverse(list);
        return list;
    }

    private void dfs(TreeNode root, ArrayList<List<Integer>> list, int index) {
        if (root == null) {
            return;
        }

        if (index > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(index - 1).add(root.val);
        dfs(root.left, list, index + 1);
        dfs(root.right, list, index + 1);
    }
}
