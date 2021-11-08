package com.myjobhunting;

public class EASY_053_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSoFar=nums[0], maxEndingHere=nums[0];
        for (int i=1;i<nums.length;++i){
            maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int maxSubArray2(int[] nums) {
        int currMax=0, ans = Integer.MIN_VALUE;
        for (int i: nums){
            currMax = currMax > 0 ? currMax+i : i;
            ans = currMax > ans? currMax: ans;
        }
        return ans;
    }


    /* Time Limit Exceeded */
    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        for(int i= 0;i<nums.length;i++)
        {
            int sum = 0;
            for(int j = i; j<nums.length;j++)
            {
                sum +=nums[j];
                max = max> sum? max: sum;
            }
        }
        return max;
    }
}
