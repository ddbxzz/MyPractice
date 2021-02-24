package ZigZagConversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        ArrayList<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int flag = -1;
        int curRow = 0;
        for (char ch : s.toCharArray()) {
            rows.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) {
                flag = -flag;
            }
            curRow += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 4));
    }


}
