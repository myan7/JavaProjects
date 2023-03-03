package com.myjobhunting;

public class EASY_1299_ReplaceElementswithGreatestElementonRightSide {

    /*
    Runtime: 2 ms, faster than 56.01% of Java online submissions for Replace Elements with The Greatest Element on Right Side.
    Memory Usage: 44.5 MB, less than 79.92% of Java online submissions for Replace Elements with The Greatest Element on Right Side.
     */
    public int[] replaceElements(int[] arr) {
        int len = arr.length;

        int[] dp = new int[len+1];
        dp[len] = -1;
        for(int i = len-1; i>=0; i--)
        {
            dp[i] = Math.max(arr[i],dp[i+1]);
            arr[i] = dp[i+1];
        }
        return arr;
    }
}
