package com.myjobhunting;
// https://leetcode.com/problems/interval-list-intersections/

import java.util.ArrayList;
import java.util.List;

/*
You are given two lists of closed intervals, firstList and secondList,
where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
Each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.

The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].

Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []

Constraints:
0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 10^9
endi < starti+1
0 <= startj < endj <= 10^9
endj < startj+1
 */
public class MEDIUM_986_IntervalListIntersections {


    /*
    Runtime: 5 ms, faster than 51.46% of Java online submissions for Interval List Intersections.
    Memory Usage: 55.2 MB, less than 14.35% of Java online submissions for Interval List Intersections.
     */
    public int[][] intervalIntersectionLC(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the startpoint of the intersection
            // hi - the endpoint of the intersection
            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi)
                ans.add(new int[]{lo, hi});

            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /*
    Runtime: 3 ms, faster than 88.53% of Java online submissions for Interval List Intersections.
    Memory Usage: 55.1 MB, less than 20.83% of Java online submissions for Interval List Intersections.
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> ans = new ArrayList<>();
        int firstIndex = 0, secondIndex = 0;
        int firstLen = firstList.length, secondLen = secondList.length;
        while(firstIndex < firstLen && secondIndex < secondLen)
        {
            int[] tmp1 = firstList[firstIndex];
            int[] tmp2 = secondList[secondIndex];
            if(tmp2[0] <= tmp1[1] && tmp2[1] >= tmp1[0])
            {
                ans.add(new int[]{Math.max(tmp1[0],tmp2[0]), Math.min(tmp2[1],tmp1[1])});
            }
            else if(tmp1[0] <= tmp2[1] && tmp1[1] >= tmp2[0])
            {
                ans.add(new int[]{Math.max(tmp1[0],tmp2[0]), Math.min(tmp1[1],tmp2[1])});
            }
            if(tmp1[1] >= tmp2[1])
                secondIndex++;
            else
                firstIndex++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
