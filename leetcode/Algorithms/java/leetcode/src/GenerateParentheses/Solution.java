package GenerateParentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //generateAll(new char[2 * n], 0, result);
        //backtrack(result, new StringBuilder(), 0, 0, n);
        //result = generate(n);
        result = bfs(n);
        return result;
    }

    //Brute Force
    private void generateAll(char[] p, int pos, List<String> list) {
        if (pos == p.length) {
            if (valid(p)) {
                list.add(new String(p));
            }
            return;
        }

        p[pos] = '(';
        generateAll(p, pos + 1, list);
        p[pos] = ')';
        generateAll(p, pos + 1, list);
    }

    private boolean valid(char[] p) {
        int banc = 0;
        for (char c : p) {
            if (c == '(') {
                banc++;
            }
            if (c == ')') {
                banc--;
            }
            if (banc < 0) {
                return false;
            }
        }

        return banc == 0;
    }

    //back track
    public void backtrack(List<String> ans, StringBuilder sb, int open, int close, int max) {
        if (sb.length() == 2 * max) {
            ans.add(sb.toString());
            return;
        }

        if (open < max) {
            sb.append('(');
            backtrack(ans, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(ans, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    //BFS
    class Node {
        private String res;
        private int left;
        private int right;

        public Node(String res, int left, int right) {
            this.res = res;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> bfs(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", 0, 0));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left == n && poll.right == n) {
                res.add(poll.res);
            }

            if (poll.left < n) {
                queue.add(new Node(poll.res + "(", poll.left + 1, poll.right));
            }
            if (poll.right < n && poll.right < poll.left) {
                queue.add(new Node(poll.res + ")", poll.left, poll.right + 1));
            }
        }
        return res;
    }

    @Test
    public void test() {
        List<String> strings = generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
