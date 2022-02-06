package com.myjobhunting;
//https://leetcode.com/problems/range-sum-query-immutable/


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

// best answer. 10 ms
class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {

        for(int i = 1; i<nums.length;i++)
        {
            nums[i] +=nums[i-1];
        }
        this.sum = nums;
    }

    public int sumRange(int i, int j) {
        return i==0? sum[j]:sum[j]-sum[i-1];
    }
}


// 48ms
public class EASY_303_RangeSumQuery_Immutable {
    int[] arr;
    public EASY_303_RangeSumQuery_Immutable(int[] nums)
    {
        this.arr = nums;
    }

    public int sumRange(int left, int right)
    {
        int sum = 0;
        for(int i = left ; i <= right; i++)
            sum += arr[i];
        return sum;
    }
}




