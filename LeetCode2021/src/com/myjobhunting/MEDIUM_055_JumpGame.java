package com.myjobhunting;

//https://leetcode.com/problems/jump-game/

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
    public boolean canJump(int[] nums) {
        int lastGoodPosition = nums.length-1;
        for(int i = nums.length-1; i>=0; i--)
        {
            if(i+ nums[i] >= lastGoodPosition)
                lastGoodPosition = i;
        }
        return lastGoodPosition == 0;
    }


}
