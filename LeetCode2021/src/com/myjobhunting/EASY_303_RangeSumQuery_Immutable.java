package com.myjobhunting;
//https://leetcode.com/problems/range-sum-query-immutable/


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
/*
Runtime: 6 ms, faster than 100.00% of Java online submissions for Range Sum Query - Immutable.
Memory Usage: 45.1 MB, less than 88.18% of Java online submissions for Range Sum Query - Immutable.
 */
class NumArray20220316 {
    private int[] sum;
    public NumArray20220316(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = nums[0];
        for(int i  = 0; i < nums.length; i++)
            sum[i+1] = sum[i] + nums[i];
    }

    public int sumRange(int left, int right) {
        return sum[right+1] - sum[left];
    }
}

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




