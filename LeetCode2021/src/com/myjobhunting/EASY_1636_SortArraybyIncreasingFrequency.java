package com.myjobhunting;

import java.util.*;

// https://leetcode.com/problems/sort-array-by-increasing-frequency/
/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]

Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100
 */
public class EASY_1636_SortArraybyIncreasingFrequency {

    /*
    Runtime: 12 ms, faster than 37.02% of Java online submissions for Sort Array by Increasing Frequency.
    Memory Usage: 45 MB, less than 18.48% of Java online submissions for Sort Array by Increasing Frequency.
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) == map.get(b) ? b - a: map.get(a) - map.get(b));
        for (int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0 ; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        int n = nums.length;
        int [] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    /*
    Runtime: 6 ms, faster than 84.94% of Java online submissions for Sort Array by Increasing Frequency.
    Memory Usage: 42.3 MB, less than 64.21% of Java online submissions for Sort Array by Increasing Frequency.
     */
    public int[] frequencySort0(int[] nums) {
        int[][] map = new int[201][2];
        for(int i : nums)
        {
            map[100+i][0] = i;
            map[100+i][1]++;
        }
        Arrays.sort(map, (a,b)-> {
            if(a[1] == b[1])
                return b[0] - a[0];
            return a[1] - b[1];
        });
        List<Integer> tmp = new ArrayList<>();
        for(int[] i : map)
        {
            if(i[1] > 0)
            {
                int count = i[1];
                while(count > 0)
                {
                    tmp.add(i[0]);
                    count--;
                }
            }
        }
        int[] ans = new int[tmp.size()];
        for(int i = 0 ; i < tmp.size(); i++)
        {
            ans[i] = tmp.get(i);
        }
        return ans;
    }
}
