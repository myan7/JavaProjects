package com.myjobhunting;

//https://leetcode.com/problems/contains-duplicate-ii/

import java.util.HashSet;
import java.util.Set;

public class EASY_219_ContainsDuplicate_II {

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
