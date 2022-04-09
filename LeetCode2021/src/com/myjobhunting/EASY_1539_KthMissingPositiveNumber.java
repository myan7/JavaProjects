package com.myjobhunting;
// https://leetcode.com/problems/kth-missing-positive-number/

/*

 */
public class EASY_1539_KthMissingPositiveNumber {

    /* this is definitely not an easy solution.
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Missing Positive Number.
    Memory Usage: 41.6 MB, less than 90.90% of Java online submissions for Kth Missing Positive Number.
     */
    public int findKthPositiveLC(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] - mid <= k) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left + k;
    }

    /*
    Runtime: 1 ms, faster than 40.69% of Java online submissions for Kth Missing Positive Number.
    Memory Usage: 43.6 MB, less than 28.01% of Java online submissions for Kth Missing Positive Number.
     */
    public int findKthPositive(int[] arr, int k) {
        int i = 1;
        for(int val : arr)
        {
            while(k > 0 && i < val)
            {
                i++;
                k--;
            }
            if(k == 0)
                return i-1;
            i++;
        }
        while(k>0)
        {
            i++;
            k--;
        }
        return i-1;
    }
}
