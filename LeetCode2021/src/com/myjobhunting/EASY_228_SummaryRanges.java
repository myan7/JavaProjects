package com.myjobhunting;

// https://leetcode.com/problems/summary-ranges/

import java.util.ArrayList;
import java.util.List;

public class EASY_228_SummaryRanges {

    // initial solution Runtime: 5 ms, faster than 87.04% of Java online submissions
    public List<String> summaryRanges00(int[] nums) {
        List<String> ans = new ArrayList<>();
        for(int left = 0; left < nums.length; )
        {
            int right = left;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[left]);
            while(right < nums.length)
            {
                if( right+1 < nums.length && nums[right]+1 == nums[right+1] )
                    right++;
                else
                    break;
            }
            if(right != left )
            {
                sb.append("->").append(nums[right]);
            }
            ans.add(sb.toString());
            left = right+1;
        }
        return ans;
    }

    // LeetCode solution Runtime: 9 ms, faster than 49.47% of Java online submissions
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;
    }

    public List<String> summaryRanges1(int[] nums) {
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
