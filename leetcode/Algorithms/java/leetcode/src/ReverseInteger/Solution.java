package ReverseInteger;

import org.junit.Test;

public class Solution {
    public int reverse(int x) {
        int res = 0;

        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x = x / 10;
        }

        return res;
    }

    @Test
    public void test() {
        int val1 = 123;
        int val2 = -12345;
        int val3 = 1534236469;
        int val4 = 2147483647;
        int val5 = -2147483647;
        assert (reverse(val1) == 321);
        assert (reverse(val2) == -54321);
        assert (reverse(val3) == 0);
        assert (reverse(val4) == 0);
        assert (reverse(val5) == 0);
    }
}
