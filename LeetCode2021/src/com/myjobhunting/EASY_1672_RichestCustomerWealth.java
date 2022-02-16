package com.myjobhunting;

// https://leetcode.com/problems/richest-customer-wealth/


public class EASY_1672_RichestCustomerWealth {
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
