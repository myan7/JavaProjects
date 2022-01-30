package com.myjobhunting;

// https://leetcode.com/problems/summary-ranges/

import java.util.ArrayList;
import java.util.List;

public class EASY_228_SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        if(nums.length == 1){
            result.add(nums[0] + "");
            return result;
        }

        for(int i = 0; i < nums.length; i++){
            int start = nums[i];
            while(i + 1 < nums.length && nums[i+1] - nums[i] == 1){
                i++;
            }
            if(start != nums[i]){
                result.add(start + "->" + nums[i]);
            } else {
                result.add(start + "");
            }
        }
        return result;
    }

    // 11ms faster than 24.73%
    public List<String> summaryRanges0(int[] nums) {
        int start = 0, end = 0;
        List<String> ans = new ArrayList<>();
        while(start < nums.length)
        {
            while(end+1 < nums.length && nums[end]+1 == nums[end+1])
                end++;
            if(start == end)
                ans.add(nums[start]+"");
            else
                ans.add(nums[start] +"->" + nums[end]);
            start = ++end;
        }
        return ans;
    }
}
