package com.myjobhunting;
// https://leetcode.com/problems/insert-interval/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
You are given an array of non-overlapping intervals intervals
where intervals[i] = [starti, endi] represent the start and the end of the ith interval and
intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order
by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:
0 <= intervals.length <= 10^4
intervals[i].length == 2
0 <= starti <= endi <= 10^5
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 10^5
 */
public class MEDIUM_057_InsertInterval {

    /*
    Runtime: 2 ms, faster than 76.23% of Java online submissions for Insert Interval.
    Memory Usage: 47.7 MB, less than 51.08% of Java online submissions for Insert Interval.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> merged = new LinkedList<>();
        int i = 0;
        // all intervals with no-overlapping before the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            merged.add(intervals[i]);
            i++;
        }
        // the intervals with overlapping
        // intervals[i][0] > newInterval[1] break the loop
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        merged.add(newInterval);
        // other non- overlapped intervals
        while (i < intervals.length) {
            merged.add(intervals[i]);
            i++;
        }
        return merged.toArray(new int[merged.size()][]);
    }

    /*
    Runtime: 4 ms, faster than 23.27% of Java online submissions for Insert Interval.
    Memory Usage: 47.9 MB, less than 36.15% of Java online submissions for Insert Interval.
     */
    public int[][] insertLC(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();

        // add all intervals starting before newInterval
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
            // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // if there is no overlap, just add an interval
            if (output.getLast()[1] < start) output.add(interval);
                // if there is an overlap, merge with the last interval
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }

    /*
    Runtime: 4 ms, faster than 23.27% of Java online submissions for Insert Interval.
    Memory Usage: 48.3 MB, less than 8.51% of Java online submissions for Insert Interval.
     */
    public int[][] insert0(int[][] intervals, int[] newInterval) {
        Stack<int[]> stack = new Stack<>();
        int lenExist = intervals.length, lenNew = newInterval.length;
        List<int[]> ans = new ArrayList<>();

        for(int i = lenExist -1; i>=0 ; i--)
        {
            stack.push(intervals[i]);
        }

        int flag = 0;
        while(!stack.isEmpty() && flag == 0 )
        {
            // if existing interval is prior to the interval
            if(flag == 0 && stack.peek()[1] < newInterval[0])
                ans.add(stack.pop());
            // else if overlapping
            else if(stack.peek()[0] <= newInterval[1])
            /*else if((stack.peek()[0] <= newInterval[0] && stack.peek()[1] >= newInterval[0])
                    || (stack.peek()[0] <= newInterval[1] && stack.peek()[1] >= newInterval[1]))*/
            {
                int[] tmp = stack.pop();
                tmp[0] = Math.min(tmp[0], newInterval[0]);
                tmp[1] = Math.max(tmp[1], newInterval[1]);
                ans.add(tmp);
                flag = 1;
            }
            // else means no overlapping, existing interval is post to the interval
            else
            {
                flag = 1;
                ans.add(newInterval);
            }
        }
        // just in case there are some leftover ranges, and check if they have overlapping
        while(!stack.isEmpty())
        {
            int[] last = ans.get(ans.size()-1);
            if(stack.peek()[0] >= last[0] && stack.peek()[1] <= last[1])
                stack.pop();
            else if(stack.peek()[0] <= last[1] )
            {
                int[] tmp = stack.pop();
                ans.remove(ans.size()-1);
                ans.add(new int[]{Math.min(last[0],tmp[0]), Math.max(last[1],tmp[1])});
            }
            else if(stack.peek()[0] > last[1])
                ans.add(stack.pop());
        }
        // if existing is blank or new interval was never reached.
        if(flag == 0 || lenExist == 0)
            ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}
