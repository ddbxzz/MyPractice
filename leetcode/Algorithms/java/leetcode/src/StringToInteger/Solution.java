package StringToInteger;

import org.junit.Test;

public class Solution {
    public int myAtoi(String s) {
        String str = s.strip();
        if (s.isEmpty() || str.isEmpty()) {
            return 0;
        }

        char[] charArray = str.toCharArray();
        int flag = 1;
        int start = 0;
        if (charArray[0] == '-') {
            flag = -1;
            start = 1;
        }
        if (charArray[0] == '+') {
            start = 1;
        }

        long sum = 0;
        for (int i = start; i < charArray.length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                break;
            }

            sum = sum * 10 + charArray[i] - '0';

            if (sum >= Integer.MAX_VALUE) {
                break;
            }
        }

        sum = sum * flag;

        if (sum <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        else if (sum >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else {
            return (int)sum;
        }
    }

    public int myAtoi1(String s) {
        if (s == null) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int idx = 0;
        while (idx < len && charArray[idx] == ' ') {
            idx++;
        }
        if (idx == len) {
            return 0;
        }

        boolean neg = false;
        if (charArray[idx] == '-') {
            neg = true;
            idx++;
        }
        else if (charArray[idx] == '+') {
            idx++;
        }
/*        else if (!Character.isDigit(charArray[idx])) {
            return 0;
        }*/

        int ans = 0;
        while (idx < len && Character.isDigit(charArray[idx])) {
            int digit = charArray[idx] - '0';
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            idx++;
        }
        return neg ? -ans : ans;

    }

    @Test
    public void test() {
        String s1 = "42";
        String s2 = "                                -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "9223372036854775808";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
        System.out.println(myAtoi(s6));
    }

}
