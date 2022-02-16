package com.myjobhunting;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class EASY_001_TwoSum {
    // just an array, not necessarily sorted
    // since you are going to return 2 indices,
    // you can not sort it and then use 2 pointers, because it is going to mess up with the index
    // you can use Burtal Force, hashMap to solve this problem

    // 1 pass hash table 1ms
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }

        return null;
    }

    // 2 passes Hash table 7 ms
    /*
    Complexity Analysis
    Time complexity: O(n).
        We traverse the list containing nn elements exactly twice.
        Since the hash table reduces the lookup time to O(1)O(1), the overall time complexity is O(n).
    Space complexity: O(n).
        The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.
     */
    public int[] twoSum1(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
        }
        return null;
    }

    // brutal force
    public int[] twoSum0(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    if (nums[i] + nums[j] == target) {
                        ans[0] = i;
                        ans[1] = j;
                        return ans;
                    }
                }
            }
        }
        return ans;
    }
}