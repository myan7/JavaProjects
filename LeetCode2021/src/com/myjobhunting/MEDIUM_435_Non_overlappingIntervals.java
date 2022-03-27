package com.myjobhunting;

// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

Constraints:
1 <= intervals.length <= 10^5
intervals[i].length == 2
-5 * 10^4 <= starti < endi <= 5 * 10^4
 */
public class MEDIUM_435_Non_overlappingIntervals {

    /*
    Runtime: 94 ms, faster than 41.09% of Java online submissions for Non-overlapping Intervals.
    Memory Usage: 100.4 MB, less than 53.96% of Java online submissions for Non-overlapping Intervals.
    I don't care what is the starting value, as long as I have the
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->  a[1]-b[1]);
        Stack<int[]> stack = new Stack<>();
        for(int[] interval : intervals)
        {
            if(stack.isEmpty())
                stack.push(interval);
            else
            {
                if(interval[0] >= stack.peek()[1])
                    stack.push(interval);
            }
        }
        return intervals.length - stack.size();
    }

// [[1,100],[11,22],[1,11],[2,12]]
// [[1,11],[1,100],[2,12],[11,22]]

// [[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
// [[-73,-26],[-65,-11],[-63,2],[-62,-49],[-52,31],[-40,-26],[-31,49],[30,47],[58,95],[66,98],[82,97],[95,99]]

    // failed
    public int eraseOverlapIntervals_failed(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] == b[0]? a[1]-b[1]: a[0]-b[0]);
        Map<Integer,Integer> intervalMap = new HashMap<>();
        for(int[] interval: intervals)
        {
            if(intervalMap.containsKey(interval[0]))
            {
                if(interval[1] >= intervalMap.get(interval[0]))
                    continue;
            }
            intervalMap.put(interval[0], interval[1]);
        }
        if(intervalMap.size() == 1)
            return intervals.length -intervalMap.size();

        int lastEnd = 0;
        for(int[] interval : intervals)
        {
            if(intervalMap.containsKey(interval[0]) && intervalMap.containsKey(interval[1]))
            {
                lastEnd = interval[1];
                continue;
            }
            else if(interval[0] == lastEnd)
                continue;
            else
            {
                if(intervalMap.containsKey(interval[0]) && !intervalMap.containsValue(interval[1]))
                    continue;
                else
                    intervalMap.remove(interval[0]);
            }
        }
        return intervals.length -intervalMap.size();
    }
}

