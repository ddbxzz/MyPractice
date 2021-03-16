package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



public class Solution {
    //排序贪心
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(o->o[0]));

        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (list.isEmpty() || list.get(list.size() - 1)[1] < L) {
                list.add(intervals[i]);
            }
            else {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], R);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
