package com.myjobhunting;

//https://leetcode.com/problems/max-area-of-island/
// Google
// Algorithm I Day 7

public class MEDIUM_695_MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int max = 0;
        for( int i = 0; i < nRow; i++)
        {
            for(int j = 0; j < nCol; j++)
            {
                if(grid[i][j] == 1)
                {
                    max = Math.max(max, getSize(grid, i, j));
                }
            }
        }
        return max;
    }

    private int getSize(int[][] grid, int sr, int sc)
    {
        int nRow = grid.length;
        int nCol = grid[0].length;
        int max= 0;
        if(sr < 0 || sc < 0 || sr >= nRow || sc >= nCol || grid[sr][sc] == 0)
        {
            return 0;
        }else if(grid[sr][sc] == 1)
        {
            // to avoid it was counted again, and stack overflow;
            grid[sr][sc] = 0;
            max = 1;
            max += getSize(grid,sr,sc+1);
            max += getSize(grid,sr,sc-1);
            max += getSize(grid,sr+1,sc);
            max += getSize(grid,sr-1,sc);
        }
        return max;
    }
}
