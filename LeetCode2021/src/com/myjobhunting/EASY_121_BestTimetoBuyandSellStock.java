package com.myjobhunting;
/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
max profit is limited one transaction?
*/
public class EASY_121_BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int minVal = Integer.MAX_VALUE;
        int minInd = 0;
        for( int i = 0; i < prices.length; i++)
        {
            if (minVal > prices[i])
            {
                minVal = prices[i];
                minInd = i;
            }
            if (i > minInd && (prices[i] - minVal) > maxDiff)
            {
                maxDiff = prices[i] - minVal;
            }
        }
        return maxDiff;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];
        int max = 0;
        for(int e: prices)
        {
            if(e<min)
                min = e;
            if(e-min>max)
                max = e-min;
        }
        return max;
    }
}
