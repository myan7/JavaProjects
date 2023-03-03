package com.myjobhunting;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/

/*
Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain,
return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

Example 1:
Input: arr = [0,1,0]
Output: 1

Example 2:
Input: arr = [0,2,1,0]
Output: 1

Example 3:
Input: arr = [0,10,5,2]
Output: 1

Constraints:
3 <= arr.length <= 10^4
0 <= arr[i] <= 10^6
arr is guaranteed to be a mountain array.
 */
public class EASY_852_PeakIndexinaMountainArray {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
    Memory Usage: 47.1 MB, less than 9.01% of Java online submissions for Peak Index in a Mountain Array.
     */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;
        while(left < right)
        {
            int mid = left +(right - left)/2;
            if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
                return mid;
            else if(arr[mid] < arr[mid+1])
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}