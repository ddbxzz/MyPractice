package PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> node = new ArrayList<>(i + 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    node.add(j, 1);
                    continue;
                }
                node.add(j, result.get(i - 1).get(j - 1) +  result.get(i - 1).get(j));
            }
            result.add(i , node);
        }
        return result;
    }
}
