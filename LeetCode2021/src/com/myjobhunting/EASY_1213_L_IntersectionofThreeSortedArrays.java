package com.myjobhunting;

import java.util.ArrayList;
import java.util.List;

/*
Given three integer arrays, arr1, arr2 and arr3 sorted in strictly increasing order,
return a sorted array of only the integers that appeared in all three arrays.

Example 1:
Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.

Example 2:
Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []

Constraints:

1 <= arr1.length, arr2.length, arr3.length <= 1000
1 <= arr1[i], arr2[i], arr3[i] <= 2000
 */
public class EASY_1213_L_IntersectionofThreeSortedArrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        int len1 = arr1.length, len2 = arr2.length, len3 = arr3.length;
        List<Integer> ans = new ArrayList<>();
        while(i < len1 && j < len2 && k < len3)
        {
            if(arr1[i] == arr2[j] && arr1[i] == arr3[k])
            {
                ans.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else
            {
                if(arr1[i] < arr2[j])
                    i++;
                else if(arr2[j] < arr3[k])
                    j++;
                else
                    k++;
            }
        }
        return ans;
    }
    // brute force. create a map and add all items appear 3 times
    public List<Integer> arraysIntersection0(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[2001];
        for(int i : arr1)
            map[i]++;
        for(int i : arr2)
            map[i]++;
        for(int i : arr3)
            map[i]++;
        for(int i = 1; i < 2001 ; i++)
        {
            if(map[i] == 3)
                ans.add(i);
        }
        return ans;
    }
}
