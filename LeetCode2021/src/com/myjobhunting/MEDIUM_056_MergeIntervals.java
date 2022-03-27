package com.myjobhunting;
// https://leetcode.com/problems/merge-intervals/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/*
Given an array of intervals where intervals[i] = [starti, endi],
merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:
1 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^4
 */
public class MEDIUM_056_MergeIntervals {

    /*
    Runtime: 6 ms, faster than 99.42% of Java online submissions for Merge Intervals.
    Memory Usage: 46.9 MB, less than 94.85% of Java online submissions for Merge Intervals.
    Time Complexity O(nlogn), space complexity O(logN) or O(N)
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /*
    Runtime: 17 ms, faster than 25.25% of Java online submissions for Merge Intervals.
    Memory Usage: 55.4 MB, less than 31.20% of Java online submissions for Merge Intervals.
     */
    public int[][] merge0(int[][] intervals) {
        if(intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0]? a[1]-b[1]: a[0]-b[0]);
        Stack<int[]> merged = new Stack<>();
        for(int[] interval : intervals)
        {
            if(merged.isEmpty())
                merged.push(interval);
            else
            {
                if(merged.peek()[1] >= interval[0])
                {
                    int[] tmp = merged.pop();
                    merged.push(new int[]{Math.min(tmp[0],interval[0]), Math.max(tmp[1],interval[1])});
                }
                else
                    merged.push(interval);
            }
        }
        int index = 0;
        int[][] ans = new int[merged.size()][2];

        for(int[] tmp : merged)
        {
            ans[index][0] = tmp[0];
            ans[index][1] = tmp[1];
            index++;
        }
        return ans;
    }
}
