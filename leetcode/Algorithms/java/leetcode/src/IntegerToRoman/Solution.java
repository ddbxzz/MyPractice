package IntegerToRoman;

import org.junit.Test;

public class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        int num1 = 2000;
        System.out.println(intToRoman(num1));
    }
}
