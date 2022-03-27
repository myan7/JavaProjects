package com.myjobhunting;
// https://leetcode.com/problems/find-pivot-index/

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index
where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.



Example 1:
Input: nums = [1,7,3,6,5,6]
Output: 3
Explanation:
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Example 2:
Input: nums = [1,2,3]
Output: -1
Explanation:
There is no index that satisfies the conditions in the problem statement.

Example 3:
Input: nums = [2,1,-1]
Output: 0
Explanation:
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0

Constraints:
1 <= nums.length <= 10^4
-1000 <= nums[i] <= 1000


Note: This question is the same as 1991: https://leetcode.com/problems/find-the-middle-index-in-array/
 */
public class EASY_724_FindPivotIndex {

    /*
    Runtime: 1 ms, faster than 99.33% of Java online submissions for Find Pivot Index.
    Memory Usage: 42.5 MB, less than 95.94% of Java online submissions for Find Pivot Index.
     */
    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len-1] = nums[len-1];

        for(int i = 1; i<len; i++){
            left[i] = left[i-1] + nums[i];
            right[len-1-i] += nums[len-i-1] + right[len-i];
        }

        for(int i=0; i < len; i++){
            if(left[i] == right[i]) return i;
        }
        return -1;
    }

    /*
    Runtime: 2 ms, faster than 69.73% of Java online submissions for Find Pivot Index.
    Memory Usage: 52.1 MB, less than 60.64% of Java online submissions for Find Pivot Index.
     */
    public int pivotIndex0(int[] nums) {
        int sum = 0, prefixSum = 0;
        for(int num : nums) sum+=num;
        for(int i = 0; i < nums.length;i++)
        {
            if(prefixSum == sum - prefixSum - nums[i])
            {
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }
}
