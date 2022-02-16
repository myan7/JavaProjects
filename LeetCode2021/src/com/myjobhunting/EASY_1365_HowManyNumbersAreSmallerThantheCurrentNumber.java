package com.myjobhunting;
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

public class EASY_1365_HowManyNumbersAreSmallerThantheCurrentNumber {

    // 1ms Dynamic programming
    public int[] smallerNumbersThanCurrent(int[] nums)
    {
        // create an array to store all the values in there, check how many 1's before it, that is the count
        // 0 <= nums[i] <= 100, so we only need 100 numbers
        // dp it
        int[] dp = new int[101];
        int[] ans = new int[nums.length];
        // initialize all the elements in nums in dp array
        for(int i : nums)
            dp[i]++;
        // save the number of 1's before that element
        for(int i = 1; i < 101; i++)
            dp[i] += dp[i-1];
        // input [6,5,4,8]
        // index [0,1,2,3]
        // map   [0,0,0,0,1,2,3,3,4]
        // index [0,1,2,3,4,5,6,7,8]
        int index = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 0)
                ans[index++] = 0;
            else
                ans[index++] = dp[nums[i]-1];
        }
        return ans;
    }

    // naive solution 19ms
    public int[] smallerNumbersThanCurrent0(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length; i++)
        {
            int count = 0;
            for(int j = 0; j < nums.length; j++)
            {
                if(j != i && nums[j] < nums[i])
                    count++;

            }
            ans[i] = count;
        }
        return ans;
    }
}
