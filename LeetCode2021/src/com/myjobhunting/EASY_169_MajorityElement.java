package com.myjobhunting;

// https://leetcode.com/problems/majority-element/
/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EASY_169_MajorityElement {

    //2ms
    public int majorityElement(int[] nums) {
        int count = 1,majority = nums[0];
        for( int i = 1; i <nums.length; i++ )
        {
            if(count == 0 || majority == nums[i]){
                majority = nums[i];
                count++;
            }
            else
                count--;
        }
        return majority;
    }
    //3ms
    public int majorityElement1(int[] nums) {
        int ans =0;
        Arrays.sort(nums);
        ans = nums[nums.length/2];
        return ans;
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int x : nums) {
            int count = counter.getOrDefault(x, 0) + 1;
            if (count > nums.length / 2) {
                return x;
            } else {
                counter.put(x, count);
            }
        }
        return -1; // invalid input
    }
    // 14 ms
    public int majorityElement3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        int maj = 0;
        int ans = 0;
        for(int k: map.keySet())
        {
            if(map.get(k) > maj)
            {
                maj = map.get(k);
                ans = k;
            }

        }
        return ans;
    }
}
