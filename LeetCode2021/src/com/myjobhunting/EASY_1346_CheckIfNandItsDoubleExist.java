package com.myjobhunting;

// https://leetcode.com/problems/check-if-n-and-its-double-exist/

import java.util.HashMap;
import java.util.Map;

/*
Given an array arr of integers,
check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :
i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]

Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

Example 2:
Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.

Example 3:
Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.

Constraints:
2 <= arr.length <= 500
-10^3 <= arr[i] <= 10^3
 */
public class EASY_1346_CheckIfNandItsDoubleExist {

    /*
    Runtime: 3 ms, faster than 56.58% of Java online submissions for Check If N and Its Double Exist.
    Memory Usage: 43.9 MB, less than 30.08% of Java online submissions for Check If N and Its Double Exist.
     */
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
        {
            int val = arr[i];
            if(map.containsKey(val))
                return true;
            int doubleVal = arr[i]*2;
            map.put(doubleVal, i);
            if(val%2 == 0)
                map.put(val/2, i);
        }
        return false;
    }
}
