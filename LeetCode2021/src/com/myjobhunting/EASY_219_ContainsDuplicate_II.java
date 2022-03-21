package com.myjobhunting;

//https://leetcode.com/problems/contains-duplicate-ii/
/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
0 <= k <= 10^5
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EASY_219_ContainsDuplicate_II {

    /*
    Runtime: 37 ms, faster than 54.80% of Java online submissions for Contains Duplicate II.
    Memory Usage: 94.7 MB, less than 32.75% of Java online submissions for Contains Duplicate II.
     */
    public boolean containsNearbyDuplicate20220316(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++)
        {
            if(map.containsKey(nums[i]))
            {
                if(Math.abs(i-map.get(nums[i])) <= k)
                    return true;
                else
                    map.put(nums[i], i);
            }
            else
                map.put(nums[i], i);
        }
        return false;
    }

    /*
    Runtime: 35 ms, faster than 61.36% of Java online submissions for Contains Duplicate II.
    Memory Usage: 77.5 MB, less than 72.44% of Java online submissions for Contains Duplicate II.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> dup = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(!dup.add(nums[i]))
                return true;
            if( dup.size() > k )
                dup.remove(nums[i-k]);
        }
        return false;
    }

    //1638 ms, faster than 5.00%
    public boolean containsNearbyDuplicate0(int[] nums, int k) {
        int len = nums.length;
        if(k > len)
            k = len;
        for(int i = k-1 ; i < len; i++)
        {
            int j = i-1;
            while(j >= 0 && j >= i-k)
            {
                if(nums[i] == nums[j])
                    return true;
                j--;
            }
        }
        return false;
    }
}
