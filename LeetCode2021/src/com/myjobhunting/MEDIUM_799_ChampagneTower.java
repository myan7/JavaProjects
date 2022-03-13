package com.myjobhunting;

// https://leetcode.com/problems/champagne-tower/

public class MEDIUM_799_ChampagneTower {

    /* DP
    Runtime: 6 ms, faster than 77.17% of Java online submissions for Champagne Tower.
    Memory Usage: 42.2 MB, less than 71.69% of Java online submissions for Champagne Tower.
     */
    public double champagneTower(int poured, int query_row, int query_glass)
    {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }

    /*
    Runtime: 10 ms, faster than 49.31% of Java online submissions for Champagne Tower.
    Memory Usage: 47.2 MB, less than 40.64% of Java online submissions for Champagne Tower.
     */
    public double champagneTower0(int poured, int query_row, int query_glass) {
        int nRow = query_row+1, nCol = query_row+1;

        double[][] glasses = new double[nRow][nCol];
        glasses[0][0] = (double)poured;

        for(int i = 0; i < nRow-1; i++)
        {
            for(int j = 0; j < i+1; j++)
            {
                double rest = Math.max(glasses[i][j] - 1.0, 0);
                glasses[i+1][j] += rest / 2.0;
                glasses[i+1][j+1] += rest / 2.0;
            }
        }

        return Math.min(glasses[query_row][query_glass], 1.0);
    }
}
