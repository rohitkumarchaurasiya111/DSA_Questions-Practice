/*
 * LeetCode 56 - Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [start, end],
 * merge all overlapping intervals and return an array of
 * the non-overlapping intervals that cover all the intervals.
 */

import java.util.*;

public class Leetcode_56_Merge_Intervals {

    public static int[][] merge(int[][] intervals) {
        //To store the results i.e. intervals without overlapping
        ArrayList<int[]> res = new ArrayList<>();

        // Sorting intervals array based on the first values so that it's easy to identify the overlapping
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            //Overlapping condition
            if (intervals[i][0] <= currEnd) {
                currEnd = Math.max(currEnd, intervals[i][1]);
            } else {        //Not overlap
                res.add(new int[] { currStart, currEnd });
                currStart = intervals[i][0];
                currEnd = intervals[i][1];
            }
        }
        //Adding last intevals
        res.add(new int[] { currStart, currEnd });

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {
                { 1, 3 },
                { 2, 6 },
                { 8, 10 },
                { 15, 18 }
        };

        int[][] result = merge(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}