package com.myjobhunting;

public class EASY_053_MaximumSubarray {

    public int maxSubArray03012022_1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            dp[i] = dp[i-1] + nums[i] < nums[i] ? nums[i]: dp[i-1] + nums[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int n : dp)
            ans = Math.max(ans, n);
        return ans;
    }

    // got that idea from house robber question. LC 198
    public int maxSubArray03012022_2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

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
            ans = Math.max(currMax, ans);
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
