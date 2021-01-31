package AddBinary;

import org.junit.Test;

public class Solution {
    public String addBinary(String a, String b) {
        int len;
        StringBuilder str = new StringBuilder();
        String tmpStr;
        int lenA = a.length();
        int lenB = b.length();
        if (a.length() <= b.length()) {
            len = a.length();
            tmpStr = b;
        }
        else {
            len = b.length();
            tmpStr = a;
        }

        int sum;
        int carry = 0;
        for (int i = lenA - 1, j = lenB - 1; i >= 0 && j >= 0; i--, j--) {
            sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            if (sum > 1) {
                sum /= 3;
                carry = 1;
            }
            else {
                carry = 0;
            }
            str.append((sum));
        }

        int appendLen = tmpStr.length() - len;
        for (int i = appendLen - 1; i >= 0; i--) {
            sum = (tmpStr.charAt(i) - '0') + carry;
            if (sum > 1) {
                sum = 0;
                carry = 1;
            }
            else {
                carry = 0;
            }
            str.append((sum));
        }
        if (carry > 0) {
            str.append(carry);
        }

        return str.reverse().toString();
    }

    @Test
    public void test() {
        String a = "100";
        String b = "110010";


        System.out.println(addBinary(a, b));
    }
}
