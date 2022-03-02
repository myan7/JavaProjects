package com.myjobhunting;
//
/*
Given an integer array nums,
return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space for space complexity analysis.)
 */
public class MEDIUM_238_ProductofArrayExceptSelf {

    // follow up
    /*
    Can you solve the problem in O(1) extra space complexity?
    (The output array does not count as extra space for space complexity analysis.)
    Runtime: 2 ms, faster than 79.36% of Java online submissions for Product of Array Except Self.
    Memory Usage: 58.5 MB, less than 5.88% of Java online submissions for Product of Array Except Self.
    O(N) time, O(1) space.
     */
    public int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;
        for(int i = 1; i < len ; i++)
        {
            ans[i] = nums[i-1]*ans[i-1];
        }

        int R = 1;
        for(int i = len-1; i >= 0; i--)
        {
            ans[i] = R*ans[i];
            R *= nums[i];
        }

        return ans;
    }

    // LeetCode solution 1
    /*
    Runtime: 4 ms, faster than 27.10% of Java online submissions for Product of Array Except Self.
    Memory Usage: 57.5 MB, less than 40.82% of Java online submissions for Product of Array Except Self.
     */
    public int[] productExceptSelf1(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] prefix = new int[len];
        int[] postfix = new int[len];

        prefix[0] = 1;
        for(int i = 1; i < len ; i++)
        {
            prefix[i] = nums[i-1]*prefix[i-1];
        }

        postfix[len-1] = 1;
        for(int i = len-2; i >= 0; i--)
        {
            postfix[i] = nums[i+1]*postfix[i+1];
        }

        for(int i = 0 ; i < len ; i++)
            ans[i] = prefix[i]*postfix[i];

        return ans;
    }


    // naive solution brute force
    // Time Limit Exceeded O(N^2)
    public int[] productExceptSelf0(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            int tmp = 1;
            for(int j = 0; j < nums.length; j++)
            {
                if(i != j)
                    tmp *= nums[j];
            }
            ans[i] = tmp;
        }
        return ans;
    }
}
