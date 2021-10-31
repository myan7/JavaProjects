package com.myjobhunting.easy;

import java.util.HashMap;

public class EASY_001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> kvMap = new HashMap<>();
        for( int i = 0; i < nums.length; i++ )
        {
            kvMap.put(nums[i],i);
        }

        for(int i = 0; i < nums.length; i++ )
        {
            int diff = target - nums[i];
            if( kvMap.containsKey(diff) && kvMap.get(diff) != i )
                return new int[] { i, kvMap.get(diff)};
        }
        return null;
    }
}
