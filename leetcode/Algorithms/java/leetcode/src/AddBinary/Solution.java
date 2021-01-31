package AddBinary;

import org.junit.Test;

public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int maxLen = (lenA < lenB) ? lenB : lenA;
        StringBuilder str = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLen; i++) {
            carry += (i < lenA) ? (a.charAt(lenA - i - 1) - '0') : 0;
            carry += (i < lenB) ? (b.charAt(lenB - i - 1) - '0') : 0;
            str.append(carry % 2);
            carry /= 2;
        }

        if (carry == 1) {
            str.append(carry);
        }

        return str.reverse().toString();
    }

    @Test
    public void test() {
        String a = "111";
        String b = "111111";


        System.out.println(addBinary(a, b));
    }
}
