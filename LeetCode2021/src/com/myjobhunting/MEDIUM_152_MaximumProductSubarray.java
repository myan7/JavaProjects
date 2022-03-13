package com.myjobhunting;
// https://leetcode.com/problems/maximum-product-subarray/
/*
Given an integer array nums,
find a contiguous non-empty sub-array within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.
A sub-array is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 10^4
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class MEDIUM_152_MaximumProductSubarray {

    /*
    Runtime: 1 ms, faster than 97.47% of Java online submissions for Maximum Product Subarray.
    Memory Usage: 42.2 MB, less than 66.43% of Java online submissions for Maximum Product Subarray.
     */
    public static int maxProduct(int[] nums) {
        int len = nums.length;
        int currMin = 1, currMax = 1;
        int ans = Integer.MIN_VALUE;

        for(int i = 0; i < len ; i++)
        {
            int prevMin = currMin, prevMax = currMax;
            currMin = Math.min(nums[i], Math.min(nums[i]*prevMin, nums[i]*prevMax));
            currMax = Math.max(nums[i], Math.max(nums[i]*prevMax, nums[i]*prevMin));
            ans = Math.max(currMax,ans);
        }
        return ans;
    }

    public static int maxProduct1(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums.length == 1)  return nums[0];
        for(int i = 0; i < nums.length;i++)
        {
            int temp = 1;
            for(int j = i; j< nums.length; j++)
            {
                temp *= nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }
    /*
    Brute force
    Runtime: 420 ms, faster than 5.02% of Java online submissions for Maximum Product Subarray.
    Memory Usage: 45 MB, less than 25.10% of Java online submissions for Maximum Product Subarray.
     */
    public static int maxProduct0(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums.length == 1)
            return nums[0];

        for(int i = 0; i < nums.length;i++)
        {
            int temp = nums[i];
            max = Math.max(max, temp);
            // add this line above is because the question was changed, contiguous sub-array was changed to allow one item.
            // not minimum 2 elements.
            for(int j = i+1; j< nums.length; j++)
            {
                temp *= nums[j];
                max = Math.max(max, temp);
            }
        }
        return max;
    }


    private static void print(int[] arr)
    {
        System.out.print("[");
        for(int i = 0; i < arr.length-1; i++)
            System.out.print(arr[i]+",");
        System.out.println(arr[arr.length-1]+"]");
    }

    public static void main(String[] args)
    {
        int[] arr = {2,3,-2,-4};
        maxProduct(arr);
    }
}
