package com.myjobhunting;

// https://leetcode.com/problems/remove-covered-intervals/

import java.util.Arrays;
import java.util.Stack;

/*
Given an array, intervals, where intervals[i] = [li, ri] represent the interval [li, ri),
remove all intervals that are covered by another interval in the list.
The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
Return the number of remaining intervals.

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1


Constraints:

1 <= intervals.length <= 1000
intervals[i].length == 2
0 <= li < ri <= 105
All the given intervals are unique.
 */
public class MEDIUM_1288_RemoveCoveredIntervals {
// [[1,2],[1,4],[3,4]] 1
// [[3,10],[4,10],[5,11]] 2
// [[1,2],[1,3]] 1
// [[1,3],[1,8],[5,8]] 1
// [[1,6],[4,6],[4,8]] 2


    /*
    Runtime: 7 ms, faster than 67.12% of Java online submissions for Remove Covered Intervals.
    Memory Usage: 47.1 MB, less than 19.78% of Java online submissions for Remove Covered Intervals.
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] == b[0]? b[1]-a[1]: a[0]-b[0]);
        int count = 0;
        int prevStart = 0, prevEnd = 0, currStart = 0, currEnd = 0;
        for(int[] curr : intervals)
        {
            currStart = curr[0];
            currEnd = curr[1];
            if(prevEnd >= currEnd && prevStart <= currStart)
                continue;
            else
            {
                count++;
                prevEnd = Math.max(currEnd,prevEnd);
                prevStart = currStart;
            }
        }
        return count;
    }

    /*
    Runtime: 7 ms, faster than 67.12% of Java online submissions for Remove Covered Intervals.
    Memory Usage: 46.8 MB, less than 34.93% of Java online submissions for Remove Covered Intervals.
     */

    public int removeCoveredIntervals_LC(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] == b[0]? b[1]-a[1]: a[0]-b[0]);
        int count = 0;
        int end, prev_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            // if current interval is not covered
            // by the previous one
            if (prev_end < end) {
                ++count;
                prev_end = end;
            }
        }
        return count;
    }

    /*
    Runtime: 6 ms, faster than 78.94% of Java online submissions for Remove Covered Intervals.
    Memory Usage: 42.4 MB, less than 84.20% of Java online submissions for Remove Covered Intervals.
     */
    public int removeCoveredIntervals0(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> a[0] == b[0]? a[1]-b[1]: a[0]-b[0]);
        Stack<int[]> stack = new Stack<>();
        for(int[] interval : intervals)
        {
            if(!stack.isEmpty() && interval[0] > stack.peek()[0] && interval[1] <= stack.peek()[1])
                continue;
            else if(!stack.isEmpty() && interval[0] <= stack.peek()[0] && interval[1] >= stack.peek()[1])
            {
                stack.pop();
                stack.push(interval);
            }
            else
                stack.push(interval);
        }
        return stack.size();
    }
}
