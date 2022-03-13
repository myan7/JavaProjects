package com.myjobhunting;

public class EASY_070_ClimbingStairs {
    //DP
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //or
    public int climbStairs1(int n) {
        // 1 step 1 way:           1
        // 2 steps 2 ways:       1,1 ;      2
        // 3 steps 3 ways:     1,1,1;     1,2;     2;1
        // 4 steps 5 ways:   1,1,1,1;   1,1,2;   1,2,1;   2,1,1;   2,2
        // 5 steps 8 ways: 1,1,1,1,1; 1,1,1,2; 1,1,2,1; 1,2,1,1; 1,2,2; 2,1,1,1; 2,1,2; 2,2,1
        // you can see for 3 steps of staircase, the ways of climbing it is actually ways of 1 step + ways of 2 steps
        // for 4 steps of staircase, the ways of climbing it is actually ways of 2 steps + ways of 3 steps
        // recursive will exceed the time limit /*Time Limit Exceeded*/
        /*
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else
            return climbStairs(n-2) + climbStairs(n-1);
        */
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for( int i = 2; i < n ; i++ )
        {
            ways[i] = ways[i-2] + ways[i-1];
        }
        return ways[n-1];
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
    Memory Usage: 41 MB, less than 29.87% of Java online submissions for Climbing Stairs.
     */
    public int climbStairs_Recur(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    private int climb_Stairs(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        return memo[i];
    }
}
