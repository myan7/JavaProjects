package com.myjobhunting;

//https://leetcode.com/problems/jump-game/

import java.util.Arrays;

/*
You are given an integer array nums.
You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5, non negative number.
 */
public class MEDIUM_055_JumpGame {

    /* O(N) genius solution.
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game.
    Memory Usage: 67.2 MB, less than 54.19% of Java online submissions for Jump Game.
     */
    public boolean canJump0(int[] nums) {
        int lastGoodPosition = nums.length-1;
        for(int i = nums.length-1; i>=0; i--)
        {
            if(i+ nums[i] >= lastGoodPosition)
                lastGoodPosition = i;
        }
        return lastGoodPosition == 0;
    }

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game.
    Memory Usage: 42.9 MB, less than 84.35% of Java online submissions for Jump Game.
     */
    public boolean canJump1(int[] nums) {
        int reachable = 0;
        for(int i = reachable; i < nums.length; i++)
        {
            if(reachable < i)
                return false;
            reachable = Math.max(i+nums[i],reachable);
        }
        return true;
    }

    /*
    DFS + DP
     */
    public boolean canJump2(int[] nums) {
        int [] dp = new int [nums.length];
        Arrays.fill(dp,-1);
        //dp[i] = -1 => meaning not processed earlier,
        //dp[i] = 0 => No path available,
        //dp[i] = 1 => path available
        return helper(nums,0,dp);
    }

    //DFS solution
    private boolean helper(int [] nums, int idx,int [] dp){

        //If we reach to the last index
        if(idx==nums.length-1)
            return true;

        //If we went out of array
        if(idx>=nums.length)
            return false;

        //If already processed
        if(dp[idx]!=-1)
            return dp[idx] == 1?true:false;

        //Take all possible jump
        int num = nums[idx];
        for(int dest = idx+1;dest<=idx+num;dest++){
            boolean ans = helper(nums,dest,dp);

            //If we found path in any of taken jump
            if(ans){
                dp[idx] = 1;
                return true;
            }
        }

        //Whatever jump we took from this index(idx), we never reached the last index of array
        dp[idx] = 0;
        return  false;
    }



}
