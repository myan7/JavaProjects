package com.myjobhunting;
// https://leetcode.com/problems/number-of-good-pairs/

import java.util.HashMap;
import java.util.Map;

public class EASY_1512_NumberofGoodPairs {


    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i: nums) // count the appearance of each item;
        {
            int count = map.getOrDefault(i,0);
            map.put(i,++count);
        }
        // if an item appears 2 times, then the combination will be 1
        // if an item appears 3 times, then the combination will be 3
        // if an item appears 4 times, then the combination will be 6 [1,2][1,3][1,4][2,3][2,4][3,4]
        // so it will be n(n-1)/2 because we don't want the repeated ones
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            result += entry.getValue() *(entry.getValue()-1)/2;
        }
        return result;
    }

    public int numIdenticalPairs0(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i+1; j < nums.length; j++)
            {
                if(nums[i] == nums[j])
                    count++;
            }
        }
        return count;
    }
}
