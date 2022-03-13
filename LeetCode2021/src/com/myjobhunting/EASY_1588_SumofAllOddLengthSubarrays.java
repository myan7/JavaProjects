package com.myjobhunting;
// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

/*
Given an array of positive integers, arr, calculate the sum of all possible odd-length sub-arrays.
A sub-array is a contiguous subsequence of the array.
Return the sum of all odd-length sub-arrays of arr.

Example 1:
Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

 */
public class EASY_1588_SumofAllOddLengthSubarrays {

    // https://www.youtube.com/watch?v=J5IIH35EBVE&ab_channel=NateSantti
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of All Odd Length Subarrays.
    Memory Usage: 41.4 MB, less than 57.10% of Java online submissions for Sum of All Odd Length Subarrays.
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int len = arr.length;

        for(int i = 0 ; i < len; i++)
        {
            int end = i+1;
            int start = len-i;
            int total = start * end;
            int odd = total/2;
            if(total%2 == 1)
                odd++;
            sum += odd * arr[i];
        }
        return sum;
    }

    // naive solution
    public int sumOddLengthSubarrays0(int[] arr) {
        int n=1;
        int ans=0;
        while(n<=arr.length)
        {
            for(int i=0;i<=arr.length-n;i++)
            {
                int movingIndex=i;
                for(int j=0;j<n;j++)
                    ans+=arr[movingIndex++];
            }
            n+=2;
        }
        return ans;
    }
}
