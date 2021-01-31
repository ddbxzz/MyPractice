package SqrtX;

import org.junit.Test;

public class Solution {
    //ln an exp
    public int mySqrt1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int ans = (int)Math.exp(0.5 * Math.log(x));
        return Math.pow(ans + 1, 2) <= x ? ans + 1 : ans;
    }

    //二分查找
    public int mySqrt2(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int lo = 0;
        int hi = x;
        int ans = lo;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if ((long)mid * mid <= x) {
                lo = mid + 1;
                ans = mid;
            }
            else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    //牛顿迭代
    public int mySqrt3(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        double C = x, ans = x;
        while (true) {
            double xi = 0.5 * (ans + C / ans);
            if (Math.abs(ans - xi) < 1e-7) {
                break;
            }
            ans = xi;
        }
        return (int) ans;
    }

    @Test
    public void test() {
        System.out.println(mySqrt2(4));
        System.out.println(mySqrt2(16));
        System.out.println(mySqrt2(2));
        System.out.println(mySqrt2(8));
        System.out.println(mySqrt2(2147395599));
    }
}
