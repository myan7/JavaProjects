package com.myjobhunting;

public class EASY_053_MaximumSubarray {
    // similar to LC 740. Delete and Earn. LC 198 house robber

    /*
    Runtime: 2 ms, faster than 67.09% of Java online submissions for Maximum Subarray.
    Memory Usage: 73.9 MB, less than 58.08% of Java online submissions for Maximum Subarray.
     */
    public int maxSubArray4(int[] nums) {
        // Initialize our variables using the first element.
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }

        return maxSubarray;
    }
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
