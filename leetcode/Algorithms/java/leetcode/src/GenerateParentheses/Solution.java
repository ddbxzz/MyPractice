package GenerateParentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll(new char[2 * n], 0, result);
        return result;
    }

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

        if (banc == 0) {
            return true;
        }

        return false;
    }

    @Test
    public void test() {
        List<String> strings = generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
