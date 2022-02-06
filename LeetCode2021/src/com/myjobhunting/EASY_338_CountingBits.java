package com.myjobhunting;

// https://leetcode.com/problems/counting-bits/

public class EASY_338_CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i = 0; i<=n; i++)
        {
            res[i] = res[i>>1]+ (i&1);
        }
        return res;
    }

    public int[] countBits0(int n) {
        int[] ans = new int[n+1];
        for(int i = 1; i < n+1 ; i++)
        {
            ans[i] = helper(i);
        }
        return ans;
    }

    private int helper(int n)
    {
        int count = 0;
        while(n != 0)
        {
            if( (n & 1) == 1 )
                count++;
            n >>= 1;
        }
        return count;
    }


}
