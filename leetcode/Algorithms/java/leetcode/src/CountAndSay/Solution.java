package CountAndSay;

import org.junit.Test;

public class Solution {
    //循环
    public String countAndSay1(int n) {
        StringBuilder result = new StringBuilder().append("1");

        if (n == 1) {
            return result.toString();
        }

        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder();

            int start = 0;
            int j = 0;
            for (; j < result.length(); j++) {
                if (result.charAt(start) != result.charAt(j)) {
                    tmp.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            tmp.append(j - start).append(result.charAt(start));

            result = tmp;
        }

        return result.toString();
    }

    //递归
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String str = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int start = 0;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(start) != str.charAt(i)) {
                result.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        result.append(i - start).append(str.charAt(start));

        return result.toString();
    }


    @Test
    public void test() {
        assert ("1".equals(countAndSay1(1)));
        assert ("11".equals(countAndSay1(2)));
        assert ("21".equals(countAndSay1(3)));
        assert ("312211".equals(countAndSay1(6)));
        assert ("13112221".equals(countAndSay1(7)));

    }
}
