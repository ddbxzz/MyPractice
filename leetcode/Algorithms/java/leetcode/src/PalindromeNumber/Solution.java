package PalindromeNumber;

import org.junit.Test;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if ( x < 0 || x % 10 == 0) {
            return false;
        }

        int res = 0;
        int tmp = x;

        while (tmp != 0) {
            res = res * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        if (res == x) {
            return true;
        }

        return false;
    }

    //反转一半数字
    public boolean isPalindrome1(int x) {
        if (x == 0) {
            return true;
        }

        if ( x < 0 || x % 10 == 0) {
            return false;
        }

        int res = 0;
        while (x > res) {
            res = res * 10 + x % 10;
            x /= 10;
        }

        if ( x == res || x == res / 10) {
            return true;
        }

        return false;
    }


    @Test
    public void test() {
        int val1 = 121;
        int val2 = -12345;
        int val3 = 10;
        int val4 = 0;
        int val5 = 12344321;
        assert (isPalindrome1(val1));
        assert (!isPalindrome1(val2));
        assert (!isPalindrome1(val3));
        assert (isPalindrome1(val4));
        assert (isPalindrome1(val5));
    }
}
