package PowxN;

import org.junit.Test;

public class Solution {
    //快速幂 + 递归
    private double quicMul1(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double y = quicMul1(x, n /2);
        //System.out.println("n = " + n + " y = " + y);
        return (n % 2 == 0) ? y * y : y * y * x;
    }

    //快速幂 + 迭代
    private double quicMul2(double x, long n) {
        double res = 1.0;
        double e = x;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= e;
            }
            e *= e;
            n >>= 1;
        }
        return res;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N < 0 ? 1.0 / quicMul2(x, -N) : quicMul2(x, N);
    }



    @Test
    public void test() {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
