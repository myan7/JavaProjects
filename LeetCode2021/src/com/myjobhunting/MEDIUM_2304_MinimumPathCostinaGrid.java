package com.myjobhunting;

import java.util.stream.IntStream;

public class MEDIUM_2304_MinimumPathCostinaGrid {

    public int minPathCost1(int[][] grid, int[][] moveCost) {
        int m=grid.length,n=grid[0].length;
        int dp[][]=new int[m][n];
        int min=Integer.MAX_VALUE;
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i==m-1){
                    dp[i][j]=grid[i][j];
                }
                else{
                    int val=Integer.MAX_VALUE;
                    for(int k=0;k<n;k++){
                        val=Math.min(val,dp[i+1][k] +grid[i][j]+ moveCost[grid[i][j]][k]);
                    }
                    dp[i][j]=val;
                }
            }
        }
        for(int i=0;i<n;i++){
            min=Math.min(dp[0][i],min);
        }
        return min;
    }

    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int c = 0; c < n; ++c) {
            cost[0][c] = grid[0][c];
        }
        for (int r = 1; r < m; ++r) {
            for (int c = 0; c < n; ++c) {
                int mi = Integer.MAX_VALUE;
                for (int j = 0; j < n; ++j) {
                    mi = Math.min(mi, cost[r - 1][j] + moveCost[grid[r - 1][j]][c]);
                }
                cost[r][c] = mi + grid[r][c];
            }
        }
        return IntStream.of(cost[m - 1]).min().getAsInt();
    }
}
