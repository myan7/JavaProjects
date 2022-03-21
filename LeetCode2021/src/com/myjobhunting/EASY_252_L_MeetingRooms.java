package com.myjobhunting;
// https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;

/*
Given an array of meeting time intervals where intervals[i] = [starti, endi],
determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti < endi <= 10^6
 */
public class EASY_252_L_MeetingRooms {

    /*
    Runtime: 4 ms, faster than 98.84% of Java online submissions for Meeting Rooms.
    Memory Usage: 42 MB, less than 83.04% of Java online submissions for Meeting Rooms.
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0] == 0? a[1]-b[1]: a[0]-b[0]);
        boolean ans = true;
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] < intervals[i-1][1])
                return false;
        }
        return ans;
    }
}
