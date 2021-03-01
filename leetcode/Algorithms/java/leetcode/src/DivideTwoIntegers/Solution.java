package DivideTwoIntegers;

public class Solution {
    /*
    https://leetcode-cn.com/problems/divide-two-integers/solution/javabu-shi-yong-longxing-yi-wei-xiang-jian-by-jzj1/
     */
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;
        int fix = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                dividend += divisor;
                fix = -1;
            }
            else {
                dividend -= divisor;
                fix = 1;
            }
        }

        boolean isNeg = false;
        if (dividend < 0) {
            dividend = -dividend;
            isNeg = !isNeg;
        }
        if (divisor < 0) {
            divisor = -divisor;
            isNeg = !isNeg;
        }

        int result = 0;
        while (dividend >= divisor) {
            int x = divisor;
            int r = 1;
            while (x <= (dividend >> 2)) {
                x <<= 1;
                r <<= 1;
            }
            dividend -= x;
            result += r;
        }

        return (isNeg ? -result : result) + fix;
    }
}
