package com.myjobhunting;
// https://leetcode.com/problems/find-greatest-common-divisor-of-array/
/*
Given an integer array, nums,
return the greatest common divisor of the smallest number and largest number in nums.
The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 */
public class EASY_1979_FindGreatestCommonDivisorofArray {

    // naive solution Runtime: 1 ms, faster than 86.06% of Java online submissions
    public int findGCD0(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i : nums)
        {
            min = Math.min(i,min);
            max = Math.max(i,max);
        }
        int divisor = min;

        while(divisor > 0)
        {
            if(max % divisor == 0 && min % divisor == 0)
                return divisor;
            else
                divisor--;
        }
        return divisor;
    }
}
