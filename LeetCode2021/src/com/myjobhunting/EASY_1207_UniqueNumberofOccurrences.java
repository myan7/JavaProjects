package com.myjobhunting;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-number-of-occurrences/
/*
Given an array of integers arr,
return true if the number of occurrences of each value in the array is unique, or false otherwise.

Example 1:
Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.

Example 2:
Input: arr = [1,2]
Output: false

Example 3:
Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

Constraints:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
 */
public class EASY_1207_UniqueNumberofOccurrences {

    /* initial solution:
    Runtime: 4 ms, faster than 35.19% of Java online submissions for Unique Number of Occurrences.
    Memory Usage: 42.7 MB, less than 8.77% of Java online submissions for Unique Number of Occurrences.
     */
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> occurrences = new HashSet<>();
        int[] counts = new int[2001];
        for(int i : arr)
        {
            if(i < 0)
                counts[Math.abs(i)+1000]++;
            else
                counts[i]++;
        }
        for(int i = 0; i < 2001; i++)
        {
            if(counts[i] != 0 && occurrences.contains(counts[i]))
                return false;
            occurrences.add(counts[i]);
        }
        return true;
    }
}
