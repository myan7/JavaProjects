package com.myjobhunting;
// https://leetcode.com/problems/count-good-triplets/
/*
Given an array of integers arr, and three integers a, b and c.
You need to find the number of good triplets.
A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
    1.  0 <= i < j < k < arr.length
    2.  |arr[i] - arr[j]| <= a
    3.  |arr[j] - arr[k]| <= b
    4.  |arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.
Return the number of good triplets.

Example 1:
Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4
Explanation: There are 4 good triplets: [(3,0,1), (3,0,1), (3,1,1), (0,1,1)].

Example 2:
Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
Explanation: No triplet satisfies all conditions.

Constraints:
3 <= arr.length <= 100
0 <= arr[i] <= 1000
0 <= a, b, c <= 1000
 */
public class EASY_1534_CountGoodTriplets {

    // slightly better solution 9 ms
    // without checking the boundaries for i, j, and k, 15ms
    // check the boundaries for them, 9 ms i < n-2, j < n-1
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i + 1; j < n-1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < n; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c)
                            count++;
                    }
                }
            }
        }
        return count;
    }

    // naive solution 19 ms
    public int countGoodTriplets0(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n ; i++)
        {
            for(int j = i+1; j < n ; j++)
            {
                for(int k = j+1 ; k < n; k++)
                {
                    if(Math.abs(arr[i] - arr[j]) <= a &&
                       Math.abs(arr[j] - arr[k]) <= b &&
                       Math.abs(arr[i] - arr[k]) <= c)
                        count++;
                }
            }
        }
        return count;
    }
}
