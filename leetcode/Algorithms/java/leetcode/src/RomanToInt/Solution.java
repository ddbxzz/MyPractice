package RomanToInt;

import org.junit.Test;


public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        int tmp = 0;

        for (int i = 1; i < s.length(); i++) {
            tmp = getValue(s.charAt(i));
            //System.out.println(tmp);
            if (preNum >= tmp) {
                sum += preNum;
            }
            else {
                sum -= preNum;
            }

            preNum = tmp;
        }

        return sum + preNum;
    }
    private int getValue(char ch) {
        switch (ch) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }

    @Test
    public void test() {
        String s1 = "MCMXCIV";
        String s2 = "III";

        assert (romanToInt(s1) == 1994);
        assert (romanToInt(s2) == 3);
    }
}
