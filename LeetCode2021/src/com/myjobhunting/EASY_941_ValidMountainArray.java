package com.myjobhunting;

// https://leetcode.com/problems/valid-mountain-array/

public class EASY_941_ValidMountainArray {


    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Mountain Array.
    Memory Usage: 54.9 MB, less than 7.96% of Java online submissions for Valid Mountain Array.
     */
    public boolean validMountainArray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;
        while (left + 1 < n && arr[left] < arr[left + 1])
            left++;
        while (right > 0 && arr[right - 1] > arr[right])
            right--;
        // peak cannot be the first or the last element
        return left > 0 && left == right && right < n - 1;
    }

    public boolean validMountainArray0(int[] arr) {
        int len = arr.length;
        int i = 0;

        //walk up
        while( i+1 < len && arr[i] < arr[i+1])
            i++;
        // peak cannot be the first or the last element
        if(i == 0 || i == len-1)
            return false;
        //walk down
        while(i+1 < len && arr[i] > arr[i+1])
            i++;
        return i== len-1;
    }
}
