package com.myjobhunting;
//https://leetcode.com/problems/contains-duplicate/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class EASY_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int i : nums)
        {
            if(!unique.add(i))
                return true;
        }
        return false;
    }

    // save some memory, which is the same as nums[i] == nums[i-1]
    public boolean containsDuplicate2(int[] nums) {
        // n^n = 0, n^0 = n
        Arrays.sort(nums);
        for(int i = 1; i< nums.length; i++)
        {
            int tmp = nums[i]^nums[i-1];
            if(tmp == 0)
                return true;
        }
        return false;
    }
}
