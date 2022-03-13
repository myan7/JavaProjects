package com.myjobhunting;
// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
Given an array of numbers arr,
return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

Example 1:
Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.

Example 2:
Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.

Constraints:
2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
 */
public class EASY_1502_CanMakeArithmeticProgressionFromSequence {

    /*
    this algorithm is to get the max and min, then find the steps.
    check if all the steps are in the list, if there is a missing one, then return false;
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        int max= Integer.MIN_VALUE, min = Integer.MAX_VALUE, len = arr.length;
        for(int num : arr)
        {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }
        if((max - min)%(len-1) != 0 ) return false;
        int gap = (max - min)/(len-1);
        if(gap == 0) return true;
        Set<Integer> set = new HashSet<>();
        for(int num : arr)
        {
            if((num-min)%gap != 0) return false;
            if(!set.add(num)) return false;
        }
        return true;
    }

    /*
    Runtime: 2 ms, faster than 78.08% of Java online submissions for Can Make Arithmetic Progression From Sequence.
    Memory Usage: 42.5 MB, less than 42.05% of Java online submissions for Can Make Arithmetic Progression From Sequence.
     */
    public boolean canMakeArithmeticProgression0(int[] arr) {
        Arrays.sort(arr);
        int ans = arr[1] - arr[0];
        for(int i = 2; i < arr.length; i++)
        {
            if(arr[i] - arr[i-1] != ans)
                return false;
        }
        return true;
    }


}
