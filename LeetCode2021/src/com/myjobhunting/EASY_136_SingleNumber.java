package com.myjobhunting;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/single-number/
Given a non-empty array of integers nums,
every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class EASY_136_SingleNumber {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int index: nums)
            ans ^= index;
        return ans;
    }

    public int singleNumber2(int[] nums) {
        int sum = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums)
        {
            if(numSet.contains(n))
                sum -= n;
            else
            {
                numSet.add(n);
                sum += n;
            }
        }
        return sum;
    }
}
