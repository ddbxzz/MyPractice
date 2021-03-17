package InsertInterval;


import java.util.ArrayList;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> result = new ArrayList<>();
        int len = intervals.length;
        int idx = 0;

        while (idx < len && intervals[idx][1] < newInterval[0]) {
            result.add(intervals[idx]);
            idx++;
        }

        while (idx < len && intervals[idx][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        result.add(newInterval);

        while (idx < len) {
            result.add(intervals[idx]);
            idx++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
