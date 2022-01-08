package com.myjobhunting;

public class EASY_070_ClimbingStairs {
//fibonacci
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        if ( n == 1 )
            ways[1] = 1;
        else if( n == 2 )
        {
            ways[1] = 1;
            ways[2] = 2;
        }
        else
        {
            ways[1] = 1;
            ways[2] = 2;
            for(int i = 3; i <=n ; i++ )
                ways[i] = ways[i-1]+ ways[i-2];
        }
        return ways[n];
    }

    //DP
    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*Time Limit Exceeded*/
    public int climbStairs3(int n) {
        // stair case 1: [1]                                                                                     1 way
        // stair case 2: [1,1], [2]                                                                              2 ways
        // stair case 3: [1,1,1], [1,2], [2,1]                                                                   3 ways
        // stair case 4: [1,1,1,1],[1,1,2],[1,2,1],[2,1,1],[2,2]                                                 5 ways
        // stair case 5: [1,1,1,1,1], [1,1,1,2], [1,1,2,1], [1,2,1,1], [1,2,2],[2,1,1,1], [2,1,2], [2,2,1]       8 ways
        int ways = 0;
        if( n == 1 )
            return 1;
        else if( n == 2 )
            return 2;
        else
        {
            ways += climbStairs(n-1) + climbStairs(n-2);
        }
        return ways;
    }
}
