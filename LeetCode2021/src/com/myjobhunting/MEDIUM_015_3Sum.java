package com.myjobhunting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MEDIUM_015_3Sum {

    /*
    Runtime: 17 ms, faster than 97.11% of Java online submissions for 3Sum.
    Memory Usage: 46.4 MB, less than 83.99% of Java online submissions for 3Sum.
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();

        for(int i=0; i<nums.length-2; i++)
        {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1]))
            {
                int target = 0-nums[i];
                int left=i+1;
                int right=nums.length-1;
                while(left < right) {
                    if (nums[left] + nums[right] == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right])); // this is the key to reduce time
                        while(left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] < target){
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return res;
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
}
