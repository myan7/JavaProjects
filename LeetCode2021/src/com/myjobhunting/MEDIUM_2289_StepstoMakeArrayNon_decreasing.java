package com.myjobhunting;

// https://leetcode.com/problems/steps-to-make-array-non-decreasing/

import java.util.LinkedList;
import java.util.Stack;

/*
You are given a 0-indexed integer array nums. In one step, remove all elements nums[i] where nums[i - 1] > nums[i] for all 0 < i < nums.length.

Return the number of steps performed until nums becomes a non-decreasing array.

Example 1:
Input: nums = [5,3,4,4,7,3,6,11,8,5,11]
Output: 3
Explanation: The following are the steps performed:
- Step 1: [5,3,4,4,7,3,6,11,8,5,11] becomes [5,4,4,7,6,11,11]
- Step 2: [5,4,4,7,6,11,11] becomes [5,4,7,11,11]
- Step 3: [5,4,7,11,11] becomes [5,7,11,11]
[5,7,11,11] is a non-decreasing array. Therefore, we return 3.

Example 2:
Input: nums = [4,5,7,7,13]
Output: 0
Explanation: nums is already a non-decreasing array. Therefore, we return 0.

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
 */
public class MEDIUM_2289_StepstoMakeArrayNon_decreasing {

    /*
    Runtime: 38 ms, faster than 100.00% of Java online submissions for Steps to Make Array Non-decreasing.
    Memory Usage: 94.1 MB, less than 50.00% of Java online submissions for Steps to Make Array Non-decreasing.
     */
    public int totalSteps(int[] nums) {
        LinkedList<int[]> stack = new LinkedList<>();
        int max = 0;
        for(int num : nums) {
            int score = 0;
            while(stack.size() > 0 && stack.getLast()[0] <= num) {
                score = Math.max(score, stack.removeLast()[1]);
            }
            stack.add(new int[]{num, stack.size() == 0 ? 0 : score+1});
            max = Math.max(max, stack.getLast()[1]);
        }
        return max;
    }

    /*
    Runtime: 144 ms, faster than 50.00% of Java online submissions for Steps to Make Array Non-decreasing.
    Memory Usage: 85 MB, less than 50.00% of Java online submissions for Steps to Make Array Non-decreasing.
     */
    public int totalSteps2(int[] nums) {
        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--) {
            if(stack.isEmpty() || stack.peek()[0] >= nums[i]) {
                stack.push(new int[]{nums[i], 0});
            }else{
                int count = 0;
                while(!stack.isEmpty() && stack.peek()[0] < nums[i]) {
                    count++;
                    int[] item = stack.pop();
                    if(count < item[1]) count += (item[1] - count);
                }
                stack.push(new int[]{nums[i], count});
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
