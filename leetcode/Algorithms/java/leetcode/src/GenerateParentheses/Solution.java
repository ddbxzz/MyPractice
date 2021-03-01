package GenerateParentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        //generateAll(new char[2 * n], 0, result);
        //backtrack(result, new StringBuilder(), 0, 0, n);
        result = generate(n);
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

    @Test
    public void test() {
        List<String> strings = generateParenthesis(2);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
