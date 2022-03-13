package com.myjobhunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MEDIUM_015_3Sum {

    /*
    Runtime: 17 ms, faster than 97.11% of Java online submissions for 3Sum.
    Memory Usage: 46.4 MB, less than 83.99% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        // need to think how to down grade it to a 2 sum
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if(len < 3)
            return ans;
        else{
            // since the array nums can have duplicates, and I want to avoid them.
            // I need to sort the array, and skip the same element for all 3 elements.
            Arrays.sort(nums);
            for(int i = 0; i < len-2; i++)
            {
                // skip the first duplicate element
                if(i > 0 && nums[i] == nums[i-1])
                    continue;
                // use 2 pointers to get the 2 sum
                int left = i+1, right = len-1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum > 0)     right--;
                    else if(sum < 0) left++;
                    else{
                        ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        // skip the second duplicate element
                        while(left < right && nums[left] == nums[left+1]) left++;
                        // skip the third duplicate element
                        while(right > left &&nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    /*
    Runtime: 105 ms, faster than 32.07% of Java online submissions for 3Sum.
    Memory Usage: 119.9 MB, less than 16.64% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        if(len < 3)
            return ans;
        // Notice that the solution set must not contain duplicate triplets.
        // we can have the first element fixed, and downgrade the problem to a 2sum problem
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]
        for(int i = 0; i < len ; i++)
        {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1, right = len -1;
            while(left < right)
            {
                List<Integer> list = new ArrayList<>();
                int sum = nums[i] + nums[left] + nums[right];
                if(sum > 0)
                    right--;
                else if (sum < 0)
                    left++;
                else
                {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while(left < len-1 && nums[left] == nums[left+1])
                        left++;
                    while(right > 0 &&nums[right] == nums[right-1])
                        right--;
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_useSet(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        var seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }
}
