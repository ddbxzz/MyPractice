package PascalTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //移位相加
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        list.add(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == i) {
                    list.add(j, 1);
                    continue;
                }
                if (j == 0) {
                    list.set(j, 1);
                    continue;
                }
                list.set(j, list.get(j) + list.get(j -1));
            }
        }

        return list;
    }
}
