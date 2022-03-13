package com.myjobhunting;
// https://leetcode.com/problems/coin-change/

import java.util.*;

/*
You are given an integer array, coins,
representing coins of different denominations and an integer, amount, representing a total amount of money.
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
 */
public class MEDIUM_322_CoinChange {
    // also check LC 2787 minimum time for the total trip.
    // or like 2 sum, 3 sum, and 4 sum or n sum.
    // this is a DP question.
    /*
    Runtime: 21 ms, faster than 75.56% of Java online submissions for Coin Change.
    Memory Usage: 44.8 MB, less than 54.27% of Java online submissions for Coin Change.
     */
    public int coinChange(int[] coins, int amount) {
        int ans = 0, min = Integer.MAX_VALUE, max = amount+1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++ )
        {
            for(int c: coins)
            {
                if( i - c >= 0)
                    dp[i] = Math.min(dp[i], 1+dp[i-c]);
            }
        }
        return dp[amount] == max? -1: dp[amount];
    }
}
