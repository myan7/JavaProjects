package com.myjobhunting;

// https://leetcode.com/problems/richest-customer-wealth/


public class EASY_1672_RichestCustomerWealth {
    /*
    Runtime: 1 ms, faster than 46.90% of Java online submissions for Richest Customer Wealth.
    Memory Usage: 44.1 MB, less than 5.81% of Java online submissions for Richest Customer Wealth.
     */
    public int maximumWealth20220312(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] account : accounts)
        {
            int tmp = 0;
            for(int bal: account)
                tmp += bal;
            max = Math.max(tmp,max);
        }
        return max;
    }

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < accounts.length; i++)
        {
            int sum = 0;
            for(int j = 0; j < accounts[0].length; j++)
            {
                sum += accounts[i][j];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
