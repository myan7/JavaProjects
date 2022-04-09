package com.myjobhunting;

// https://leetcode.com/problems/3sum-with-multiplicity/

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array arr, and an integer target,
return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.
As the answer can be very large, return it modulo 109 + 7.

Example 1:
Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation:
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Example 2:
Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation:
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.

Constraints:
3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
 */
public class MEDIUM_923_3SumWithMultiplicity {

    /*
    Runtime: 718 ms, faster than 13.31% of Java online submissions for 3Sum With Multiplicity.
    Memory Usage: 42.3 MB, less than 79.03% of Java online submissions for 3Sum With Multiplicity.
     */
    public int threeSumMulti_LC(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            res = (res + map.getOrDefault(target - arr[i], 0)) % mod;
            for (int j = 0; j < i; j++) {
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }

    /*
    Runtime: 28 ms, faster than 56.05% of Java online submissions for 3Sum With Multiplicity.
    Memory Usage: 41.8 MB, less than 87.10% of Java online submissions for 3Sum With Multiplicity.
     */
    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length, M = (int)1e9 + 7;
        int[][] dp = new int[target + 1][4];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= arr[i]; j--) {
                for (int k = 3; k >= 1; k--) {
                    dp[j][k] += dp[j - arr[i]][k - 1];
                    dp[j][k] %= M;
                }
            }
        }
        return dp[target][3];
    }
}
